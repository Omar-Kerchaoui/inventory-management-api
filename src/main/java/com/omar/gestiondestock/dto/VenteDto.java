package com.omar.gestiondestock.dto;

import com.omar.gestiondestock.model.Role;
import com.omar.gestiondestock.model.Vente;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class VenteDto {

    private Integer id;

    private String code;

    private Instant dateVente;

    private String commentaire;

    public static VenteDto fromEntity(Vente vente){
        if (vente == null){
            return null;
        }
        return VenteDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .dateVente(vente.getDateVente())
                .commentaire(vente.getCommentaire())
                .build();

    }

    public static Vente toEntity(VenteDto venteDto){
        if(venteDto == null){
            return null;
        }

        Vente vente  = new Vente();
        vente.setId(venteDto.getId());
        vente.setCode(venteDto.getCode());
        vente.setDateVente(venteDto.getDateVente());
        vente.setCommentaire(venteDto.getCommentaire());
        return vente;
    }
}
