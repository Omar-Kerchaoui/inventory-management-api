package com.omar.gestiondestock.service;

import com.omar.gestiondestock.dto.ArticleDto;
import com.omar.gestiondestock.dto.LigneCommandeClientDto;
import com.omar.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.omar.gestiondestock.dto.LigneVenteDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto dto);
    ArticleDto findById (Integer id);
    ArticleDto findByCodeArticle(String codeArticle);

    List<ArticleDto> findAll();

    List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

    List<LigneCommandeClientDto> findHistoriqueCommandeClient(Integer idArticle);

     List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

     List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);

    void delete (Integer id);
}
