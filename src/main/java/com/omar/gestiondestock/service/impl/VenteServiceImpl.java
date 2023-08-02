package com.omar.gestiondestock.service.impl;

import com.omar.gestiondestock.dto.CommandeClientDto;
import com.omar.gestiondestock.dto.LigneVenteDto;
import com.omar.gestiondestock.dto.VenteDto;
import com.omar.gestiondestock.exception.EntityNotFoundException;
import com.omar.gestiondestock.exception.ErrorCodes;
import com.omar.gestiondestock.exception.InvalidEntityException;
import com.omar.gestiondestock.model.Article;
import com.omar.gestiondestock.model.LigneVente;
import com.omar.gestiondestock.model.Vente;
import com.omar.gestiondestock.repository.ArticleRepository;
import com.omar.gestiondestock.repository.LigneVenteRepository;
import com.omar.gestiondestock.repository.VenteRepository;
import com.omar.gestiondestock.service.VenteService;
import com.omar.gestiondestock.validator.VenteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VenteServiceImpl implements VenteService {

    private ArticleRepository articleRepository;
    private VenteRepository venteRepository;
    private LigneVenteRepository ligneVenteRepository;

    public VenteServiceImpl(ArticleRepository articleRepository, VenteRepository venteRepository, LigneVenteRepository ligneVenteRepository) {
        this.articleRepository = articleRepository;
        this.venteRepository = venteRepository;
        this.ligneVenteRepository = ligneVenteRepository;
    }

    @Override
    public VenteDto save(VenteDto dto) {

        List<String> errors = VenteValidator.validate(dto);

        // verification premier niveau
        if (!errors.isEmpty()) {
            log.error("vente n'est pas valide");
            throw new InvalidEntityException("la vente n'est pas valide", ErrorCodes.VENTE_NOT_VALID);
        }

        List<String> articleErrors = new ArrayList<>();

        if (dto.getLigneVente() != null) {
            dto.getLigneVente().forEach(ligVente -> {
                if (ligVente.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligVente.getArticle().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("L'article avec l'ID " + ligVente.getArticle().getId() + " n'existe pas");
                    }
                } else {
                    articleErrors.add("Implossible d'enregister une vente avec un article null");
                }
            });
        }

        if (!articleErrors.isEmpty()) {
            log.warn("one ore more articles were not found in the DB {}", errors);
            throw new InvalidEntityException("Un ou plusieurs article n'ont pas ete trouve dans la base de donne.", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }

        Vente savedVente = venteRepository.save(VenteDto.toEntity(dto));

        if (dto.getLigneVente() != null) {
            dto.getLigneVente().forEach(ligVenteDto -> {
                LigneVente ligneVente = LigneVenteDto.toEntity(ligVenteDto);
                ligneVente.setVente(savedVente);
                ligneVenteRepository.save(ligneVente);
            });
        }

        return VenteDto.fromEntity(savedVente);
    }

    @Override
    public VenteDto findById(Integer id) {
        if (id == null) {
            log.warn("Vente Id is NULL");
            return null;
        }
        return venteRepository.findById(id)
                .map(VenteDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun vente n'a ete trouve dans la BDD", ErrorCodes.VENTE_NOT_FOUND));
    }

    @Override
    public VenteDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Vente code is NULL");
            return null;
        }
        return venteRepository.findVenteByCode(code)
                .map(VenteDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune vente n'a ete trouve avec le code " + code, ErrorCodes.VENTE_NOT_FOUND
                ));
    }

    @Override
    public List<VenteDto> findAll() {
        return venteRepository.findAll().stream()
                .map(VenteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if (id == null) {
            log.error("Vente id is null");
            return;
        }
        venteRepository.deleteById(id);
    }
}
