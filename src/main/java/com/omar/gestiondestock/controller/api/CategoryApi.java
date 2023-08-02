package com.omar.gestiondestock.controller.api;

import com.omar.gestiondestock.dto.CategoryDto;
import com.omar.gestiondestock.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.omar.gestiondestock.utils.Constants.APP_ROOT;

@Api(Constants.APP_ROOT+"/categories")
public interface CategoryApi {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'objet category cree / modifie"),
            @ApiResponse(responseCode = "404", description = "L'objet category n'est pas valide")
    })
    @Operation(
            summary = "Enregistrer une category",
            description = "Cette methode permet d'enregistrer ou modifier une category")
    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(CategoryDto dto);


    @Operation(
            summary = "Rechercher une category par son ID",
            description = "Cette methode permet de chercher une category par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La category a ete trouve dans la BDD"),
            @ApiResponse(responseCode = "404", description = "Aucun category n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = APP_ROOT + "/categories/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("idCategory") Integer id);

    @Operation(
            summary = "Rechercher une category par son code",
            description = "Cette methode permet de chercher une category par son code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La category a ete trouve dans la BDD"),
            @ApiResponse(responseCode = "404", description = "Aucun category n'existe dans la BDD avec le code fourni")
    })
    @GetMapping(value = APP_ROOT + "/categories/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCode(@PathVariable("codeCategory") String code);


    @Operation(
            summary = "Renvoi la liste des categories",
            description = "Cette methode permet de chercher et renvoyer la liste des categories que existent dans la BDD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La liste des categories / une liste vide"),
    })
    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @Operation(
            summary = "Supprimer une category",
            description = "Cette methode permet de supprimer une category par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La category a ete supprime"),
    })
    @DeleteMapping(value = APP_ROOT + "/categories/delete/{idCategory}")
    void delete(@PathVariable("idCategory") Integer id);
}
