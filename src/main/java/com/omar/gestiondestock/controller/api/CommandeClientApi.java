package com.omar.gestiondestock.controller.api;

import com.omar.gestiondestock.dto.CommandeClientDto;
import com.omar.gestiondestock.dto.LigneCommandeClientDto;
import com.omar.gestiondestock.model.EtatCommande;
import com.omar.gestiondestock.utils.Constants;
import io.swagger.annotations.Api;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Api(Constants.APP_ROOT + "/commandesclients")
public interface CommandeClientApi {

    @PostMapping(Constants.APP_ROOT + "/commandesclients/create")
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto);

    @PatchMapping(Constants.APP_ROOT + "/commandesclients/update/etat/{idCommande}/{etatCommande}")
    ResponseEntity<CommandeClientDto> updateEtatCommande(@PathVariable("idCommande") Integer idCommande,
                                                         @PathVariable("etatCommande") EtatCommande etatCommande);

    @PatchMapping(Constants.APP_ROOT + "/commandesclients/update/quantite/{idCommande}/{idLigneCommande}/{quantite}")
    ResponseEntity<CommandeClientDto> updateQuantiteCommande(@PathVariable("idCommande") Integer idCommande,
                                                             @PathVariable("idLigneCommande") Integer idLigneCommande,
                                                             @PathVariable("quantite") BigDecimal quantite);

    @PatchMapping(Constants.APP_ROOT + "/commandesclients/update/client/{idCommande}/{idClient}")
    ResponseEntity<CommandeClientDto> updateClient(@PathVariable("idCommande") Integer idCommande,
                                                   @PathVariable("idClient") Integer idClient);

    @PatchMapping(Constants.APP_ROOT + "/commandesclients/update/article/{idCommande}/{idLigneCommande}/{idArticle}")
    ResponseEntity<CommandeClientDto> updateArticle(@PathVariable("idCommande") Integer idCommande,
                                                    @PathVariable("idLigneCommande") Integer idLigneCommande,
                                                    @PathVariable("idArticle") Integer idArticle);


    @DeleteMapping(Constants.APP_ROOT + "/commandesclients/delete/article/{idCommande}/{idLigneCommande}")
    ResponseEntity<CommandeClientDto> deleteArticle(@PathVariable("idCommande") Integer idCommande,
                                                    @PathVariable("idLigneCommande") Integer idLigneCommande);


    @GetMapping(Constants.APP_ROOT + "/commandesclients/lignesCommandes/{idCommande}")
    ResponseEntity<List<LigneCommandeClientDto>> findAllLigneCommandeClientByCommandeClientId(Integer idCommande);

    @GetMapping(Constants.APP_ROOT + "/commandesclients/{idCommandeClient}")
    ResponseEntity<CommandeClientDto> findById(Integer idCommandeClient);

    @GetMapping(Constants.APP_ROOT + "/commandesclients/{codeCommandeClient}")
    ResponseEntity<CommandeClientDto> findByCode(@PathVariable("codeCommandeClient") String code);

    @GetMapping(Constants.APP_ROOT + "/commmandesclients/all")
    ResponseEntity<List<CommandeClientDto>> findAll();

    @DeleteMapping(Constants.APP_ROOT + "/commandesclients/delete/{idCommandeClient}")
    ResponseEntity<Void> delete(@PathVariable("idCommandeClient") Integer id);
}
