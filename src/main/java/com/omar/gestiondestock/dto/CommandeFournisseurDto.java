package com.omar.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omar.gestiondestock.model.CommandeClient;
import com.omar.gestiondestock.model.CommandeFournisseur;
import com.omar.gestiondestock.model.EtatCommande;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class CommandeFournisseurDto {

    private Integer id;

    private String code;

    private Instant dateCommande;

    private FournisseurDto fournisseur;

    private EtatCommande etatCommande;

    private Integer idEntreprise;

    @JsonIgnore
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;


    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
        if (commandeFournisseur == null){
            return null;
        }
        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .idEntreprise(commandeFournisseur.getIdEntreprise())
                .fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
                .etatCommande(commandeFournisseur.getEtatCommande())
                .ligneCommandeFournisseurs(
                        commandeFournisseur.getLigneCommandeFournisseurs() != null ?
                                commandeFournisseur.getLigneCommandeFournisseurs().stream()
                                        .map(LigneCommandeFournisseurDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();

    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto){
        if(commandeFournisseurDto == null){
            return null;
        }

        CommandeFournisseur commandeFournisseur  = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCode(commandeFournisseurDto.getCode());
        commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
        commandeFournisseur.setEtatCommande(commandeFournisseurDto.getEtatCommande());

        return commandeFournisseur;
    }

    public boolean isCommandeLivree(){return EtatCommande.LIVREE.equals(this.etatCommande);};

}
