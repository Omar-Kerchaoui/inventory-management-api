package com.omar.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class CommandeClient extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column (name = "datecommande")
    private Instant dateCommande;

    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;

    @Column(name = "idEntreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommandeClient> ligneCommandeClients;

}
