package com.omar.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omar.gestiondestock.model.Article;
import com.omar.gestiondestock.model.CommandeClient;
import com.omar.gestiondestock.model.Fournisseur;
import com.omar.gestiondestock.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@Builder
@Data
public class LigneCommandeClientDto {

    private Integer id;

    private Article article;

    private CommandeClient commandeClient;

    private BigDecimal quantite;

    private Integer idEntreprise;

    private BigDecimal prixUnitaire;


    public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient){
        if (ligneCommandeClient == null){
            return null;
        }
        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .article(ligneCommandeClient.getArticle())
                .idEntreprise(ligneCommandeClient.getIdEntreprise())
                .commandeClient(ligneCommandeClient.getCommandeClient())
                .quantite(ligneCommandeClient.getQuantite())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .build();

    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto){
        if(ligneCommandeClientDto == null){
            return null;
        }

        LigneCommandeClient ligneCommandeClient  = new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.getId());
        ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
        ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());


        return ligneCommandeClient;
    }
}
