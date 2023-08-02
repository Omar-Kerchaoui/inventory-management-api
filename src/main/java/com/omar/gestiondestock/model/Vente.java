package com.omar.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Entity
public class Vente extends AbstractEntity{
    @Column(name = "code")
    private String code;

    @Column(name = "dateVente")
    private Instant dateVente;

    @Column(name = "idEntreprise")
    private Integer idEntreprise;

    @Column(name="commentaire")
    private String commentaire;

    @OneToMany(mappedBy = "vente")
    private List<LigneVente> ligneVente;
}
