package com.omar.gestiondestock.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChangerMotDePasseUtilisateurDto {

    private Integer id;

    private String email;

    private String motDePasse;

    private String confirmMotDePasse;

}
