package com.omar.gestiondestock.service.impl;

import com.omar.gestiondestock.dto.ArticleDto;
import com.omar.gestiondestock.exception.EntityNotFoundException;
import com.omar.gestiondestock.exception.ErrorCodes;
import com.omar.gestiondestock.exception.InvalidEntityException;
import com.omar.gestiondestock.model.Article;
import com.omar.gestiondestock.repository.ArticleRepository;
import com.omar.gestiondestock.service.ArticleService;
import com.omar.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        // validation
        List<String> errors = ArticleValidator.validate(dto);
        if (errors.isEmpty()) {
            log.error("Article is not valid {)", dto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        Article savedArticle = articleRepository.save(ArticleDto.toEntity(dto));

        return ArticleDto.fromEntity(savedArticle);
    }

    @Override
    public ArticleDto findById(Integer id) {

        if (id == null) {
            log.error("Article Id is null");
            return null;
        }

        Optional<Article> article = articleRepository.findById(id);

        ArticleDto dto = ArticleDto.fromEntity(article.get());


        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun article avec l'ID = " + id + " n'a ete trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND
                )
        );
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)) {
            log.error("Article code is null");
            return null;
        }

        Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);

        ArticleDto dto = ArticleDto.fromEntity(article.get());


        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun article avec le code = " + codeArticle + " n'a ete trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND
                )
        );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article Id is null");
            return;
        }

        articleRepository.deleteById(id);
    }
}
