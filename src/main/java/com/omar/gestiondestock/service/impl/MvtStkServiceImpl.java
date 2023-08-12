package com.omar.gestiondestock.service.impl;

import com.omar.gestiondestock.dto.MvtStkDto;
import com.omar.gestiondestock.exception.ErrorCodes;
import com.omar.gestiondestock.exception.InvalidEntityException;
import com.omar.gestiondestock.model.TypeMvtStk;
import com.omar.gestiondestock.repository.MvtStkRepository;
import com.omar.gestiondestock.service.ArticleService;
import com.omar.gestiondestock.service.MvtStkService;
import com.omar.gestiondestock.validator.MvtStkValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MvtStkServiceImpl implements MvtStkService {

    private MvtStkRepository repository;
    private ArticleService articleService;

    @Autowired
    public MvtStkServiceImpl(MvtStkRepository repository, ArticleService articleService) {
        this.repository = repository;
        this.articleService = articleService;
    }

    @Override
    public BigDecimal stockReelArticle(Integer idArticle) {

        if (idArticle == null) {
            log.warn("ID article is NULL");
            return BigDecimal.valueOf(-1);
        }

        // for validation purposes
        articleService.findById(idArticle);

        return repository.stockReelArticle(idArticle);
    }

    @Override
    public List<MvtStkDto> mvtStkArticle(Integer idArticle) {

        return repository.findAllByArticleId(idArticle).stream()
                .map(MvtStkDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MvtStkDto entreeStock(MvtStkDto dto) {
        return entreePostitive(dto, TypeMvtStk.ENTREE);
    }

    @Override
    public MvtStkDto sortieStock(MvtStkDto dto) {

      return sortieNegative(dto, TypeMvtStk.SORTIE);
    }

    @Override
    public MvtStkDto correctionStockPos(MvtStkDto dto) {

       return entreePostitive(dto, TypeMvtStk.CORRECTION_POS);
    }

    @Override
    public MvtStkDto correctionStockNeg(MvtStkDto dto) {

        return entreePostitive(dto, TypeMvtStk.CORRECTION_NEG);
    }

    private MvtStkDto entreePostitive(MvtStkDto mvtStkDto, TypeMvtStk typeMvtStk){

        List<String> errors = MvtStkValidator.validate(mvtStkDto);

        if (!errors.isEmpty()) {
            log.error("Fournisseur is not valid {}", mvtStkDto);
            throw new InvalidEntityException("Le mouvement de stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
        }

        mvtStkDto.setQuantite(
                BigDecimal.valueOf(
                        Math.abs(mvtStkDto.getQuantite().doubleValue())
                )
        );

        mvtStkDto.setTypeMvt(typeMvtStk);

        return MvtStkDto.fromEntity(
                repository.save(MvtStkDto.toEntity(mvtStkDto))
        );
    }

    private MvtStkDto sortieNegative(MvtStkDto dto, TypeMvtStk typeMvtStk){

        List<String> errors = MvtStkValidator.validate(dto);

        if (!errors.isEmpty()) {
            log.error("Fournisseur is not valid {}", dto);
            throw new InvalidEntityException("Le mouvement de stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
        }

        dto.setQuantite(
                BigDecimal.valueOf(
                        Math.abs(dto.getQuantite().doubleValue()) * -1
                )
        );

        dto.setTypeMvt(TypeMvtStk.SORTIE);

        return MvtStkDto.fromEntity(
                repository.save(MvtStkDto.toEntity(dto))
        );

    }
}
