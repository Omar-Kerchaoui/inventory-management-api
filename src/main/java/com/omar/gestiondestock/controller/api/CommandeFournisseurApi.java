package com.omar.gestiondestock.controller.api;

import com.omar.gestiondestock.dto.CommandeFournisseurDto;
import com.omar.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.omar.gestiondestock.model.EtatCommande;
import com.omar.gestiondestock.utils.Constants;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Api(Constants.COMMMANDE_FOURNISSEUR_ENDPOINT)
public interface CommandeFournisseurApi {

    @PostMapping(Constants.CREATE_COMMMANDE_FOUNISSEUR_ENDPOINT)
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto dto);

    @GetMapping(Constants.FIND_COMMMANDE_FOURNISSEUR_BY_ID_ENDPOINT)
    CommandeFournisseurDto findById(@PathVariable("idCommandeFournisseur") Integer id);

    @GetMapping(Constants.FIND_COMMANDE_FOURNISSEUR_BY_CODE_ENDPOINT)
    CommandeFournisseurDto findByCode(@PathVariable("codeCommandeFournisseur") String code);

    @PatchMapping(Constants.APP_ROOT + "/commandesfournisseurs/update/etat/{idCommande}/{etatCommande}")
    ResponseEntity<CommandeFournisseurDto> updateEtatCommande(@PathVariable("idCommande") Integer idCommande,
                                                         @PathVariable("etatCommande") EtatCommande etatCommande);

    @PatchMapping(Constants.APP_ROOT + "/commandesfournisseurs/update/quantite/{idCommande}/{idLigneCommande}/{quantite}")
    ResponseEntity<CommandeFournisseurDto> updateQuantiteCommande(@PathVariable("idCommande") Integer idCommande,
                                                             @PathVariable("idLigneCommande") Integer idLigneCommande,
                                                             @PathVariable("quantite") BigDecimal quantite);

    @PatchMapping(Constants.APP_ROOT + "/commandesfournisseurs/update/fournisseur/{idCommande}/{idFournisseur}")
    ResponseEntity<CommandeFournisseurDto> updateFournisseur(@PathVariable("idCommande") Integer idCommande,
                                                   @PathVariable("idFournisseur") Integer idFournisseur);

    @PatchMapping(Constants.APP_ROOT + "/commandesfournisseurs/update/article/{idCommande}/{idLigneCommande}/{idArticle}")
    ResponseEntity<CommandeFournisseurDto> updateArticle(@PathVariable("idCommande") Integer idCommande,
                                                    @PathVariable("idLigneCommande") Integer idLigneCommande,
                                                    @PathVariable("idArticle") Integer idArticle);


    @DeleteMapping(Constants.APP_ROOT + "/commandesfournisseurs/delete/article/{idCommande}/{idLigneCommande}")
    ResponseEntity<CommandeFournisseurDto> deleteArticle(@PathVariable("idCommande") Integer idCommande,
                                                    @PathVariable("idLigneCommande") Integer idLigneCommande);

    @GetMapping(Constants.APP_ROOT + "/commandesfournisseurs/lignesCommandes/{idCommande}")
    ResponseEntity<List<LigneCommandeFournisseurDto>> findAllLigneCommandeFournisseurByCommandeFournisseurId(Integer idCommande);


    @GetMapping(Constants.FIND_ALL_COMMMANDE_FOURNISSEUR_ENDPOINT)
    List<CommandeFournisseurDto> findAll();

    @DeleteMapping(Constants.DELETE_COMMMANDE_FOURNISSEUR_ENDPOINT)
    void delete(@PathVariable("idCommandeFournisseur") Integer id);
}
