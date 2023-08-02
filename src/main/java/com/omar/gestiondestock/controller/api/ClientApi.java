package com.omar.gestiondestock.controller.api;

import com.omar.gestiondestock.dto.ClientDto;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.omar.gestiondestock.utils.Constants.APP_ROOT;

@Api(APP_ROOT+"/clients")
public interface ClientApi {


    @Operation(
            summary = "Enregistrer un client",
            description = "Cette methode permet d'enregistrer ou modifier un client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'objet client cree / modifie"),
            @ApiResponse(responseCode = "404", description = "L'objet client n'est pas valide")
    })
    @PostMapping(value = APP_ROOT + "/clients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(ClientDto dto);


    @Operation(
            summary = "Rechercher un client par son ID",
            description = "Cette methode permet de chercher un client par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le client a ete trouve dans la BDD"),
            @ApiResponse(responseCode = "404", description = "Aucun client n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = APP_ROOT + "/clients/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(Integer id);


    @Operation(
            summary = "Renvoi la liste des clients",
            description = "Cette methode permet de chercher et renvoyer la liste des clients que existent dans la BDD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La liste des clients / une liste vide"),
    })
    @GetMapping(value = APP_ROOT + "/clients/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();


    @Operation(
            summary = "Supprimer un client",
            description = "Cette methode permet de supprimer un client par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La category a ete supprime"),
    })
    @DeleteMapping(value = APP_ROOT + "/categories/delete/{idCategory}")
    void delete(Integer id);

}
