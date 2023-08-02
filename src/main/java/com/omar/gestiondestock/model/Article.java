package com.omar.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Article extends AbstractEntity {

    @Column(name = "codearticle")
    private String codeArticle;

    @Column (name = "designation")
    private String designation;

    @Column (name = "poixunitaiceht")
    private BigDecimal prixUnitaireHt;

    @Column (name = "tauxtva")
    private BigDecimal tauxTva;

    @Column (name = "prixunitairettc")
    private BigDecimal prixUnitaireTtc;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @Column (name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name="idCategory")
    private Category category;
}
