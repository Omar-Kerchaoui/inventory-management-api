package com.omar.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Client extends AbstractEntity{

    @Column(name = "non")
    private String nom;

    @Column (name = "prenom")
    private String prenom;

    @Embedded
    private Adresse adresse;

    @Column (name="photo")
    private String photo;

    @Column (name = "mail")
    private String mail;

    @Column(name = "identreprise",insertable=false, updatable=false)
    private Integer idEntreprise;

    @Column (name = "nunTel")
    private String numTel;

    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClients;
}
