package com.omar.gestiondestock.controller.api;

import com.omar.gestiondestock.dto.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.omar.gestiondestock.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/articles")
public interface ArticleApi {

    @Operation(
            summary = "Enregistrer un article",
            description = "Cette methode permet d'enregistrer ou modifier un article")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'objet article cree / modifie"),
            @ApiResponse(responseCode = "404", description = "L'objet article n'est pas valide")
    })
    @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto dto);


    @Operation(
            summary = "Rechercher un article par son ID",
            description = "Cette methode permet de chercher un article par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'article a ete trouve dans la BDD"),
            @ApiResponse(responseCode = "404", description = "Aucun article n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable(name = "idArticle") Integer id);


    @Operation(
            summary = "Rechercher un article par son code",
            description = "Cette methode permet de chercher un article par son code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'article a ete trouve dans la BDD"),
            @ApiResponse(responseCode = "404", description = "Aucun article n'existe dans la BDD avec le code fourni")
    })
    @GetMapping(value = APP_ROOT + "/articles/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable(name = "codeArticle") String codeArticle);


    @Operation(
            summary = "Renvoi la liste des articles",
            description = "Cette methode permet de chercher et renvoyer la liste des articles que existent dans la BDD")
    @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La liste des article / une liste vide"),
    })
    List<ArticleDto> findAll();

    @Operation(
            summary = "Supprimer un article",
            description = "Cette methode permet de supprimer un article par son ID")
    @DeleteMapping(value = APP_ROOT + "/articles/delete/{idArticle}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'article a ete supprime"),
    })
    void delete(@PathVariable(name = "idArticle") Integer id);
}
