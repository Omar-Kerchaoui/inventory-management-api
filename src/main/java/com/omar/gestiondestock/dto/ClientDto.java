package com.omar.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omar.gestiondestock.model.Adresse;
import com.omar.gestiondestock.model.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class ClientDto {

    private Integer id;

    private String nom;

    private String prenom;

    private Adresse adresse;

    private String photo;

    private String mail;

    private String numTel;

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;


    public static ClientDto fromEntity(Client client){
        if (client == null){
            return null;
        }
        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(client.getAdresse())
                .photo(client.getPhoto())
                .mail(client.getMail())
                .numTel(client.getNumTel())
                .commandeClients(
                        client.getCommandeClients() != null ?
                                client.getCommandeClients().stream()
                                        .map(CommandeClientDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();

    }

    public static Client toEntity(ClientDto clientDto){
      if(clientDto == null){
          return null;
      }

      Client client  = new Client();
      client.setId(clientDto.getId());
      client.setNom(clientDto.getNom());
      client.setPrenom(clientDto.getPrenom());
      client.setAdresse(clientDto.getAdresse());
      client.setPhoto(clientDto.getPhoto());
      client.setMail(clientDto.getMail());
      client.setNumTel(clientDto.getNumTel());

      return client;
    }
}
