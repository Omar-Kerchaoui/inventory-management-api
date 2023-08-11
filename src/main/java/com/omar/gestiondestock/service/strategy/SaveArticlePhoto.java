package com.omar.gestiondestock.service.strategy;

import com.flickr4java.flickr.FlickrException;
import com.omar.gestiondestock.dto.ArticleDto;
import com.omar.gestiondestock.exception.ErrorCodes;
import com.omar.gestiondestock.exception.InvalidOperationException;
import com.omar.gestiondestock.model.Article;
import com.omar.gestiondestock.service.ArticleService;
import com.omar.gestiondestock.service.FlickrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("articleStrategy")
@Slf4j
public class SaveArticlePhoto implements Strategy<ArticleDto> {

    private FlickrService flickrService;
    private ArticleService articleService;

    @Autowired
    public SaveArticlePhoto(FlickrService flickrService, ArticleService articleService) {
        this.flickrService = flickrService;
        this.articleService = articleService;
    }

    @Override
    public ArticleDto savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
        ArticleDto articleDto = articleService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo, titre);

        if (!StringUtils.hasLength(urlPhoto)) {
            throw new InvalidOperationException("Erreur lors de l'enregistrement de photo de l'article",
                    ErrorCodes.UPDATE_PHOTO_EXCEPTION);
        }

        articleDto.setPhoto(urlPhoto);
        return articleService.save(articleDto);
    }
}
