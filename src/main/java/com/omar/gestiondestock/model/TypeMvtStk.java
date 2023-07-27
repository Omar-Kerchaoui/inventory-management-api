package com.omar.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class TypeMvtStk extends AbstractEntity {
    @Column(name = "nom")
    private String nom;

    @Column(name = "idEntreprise")
    private Integer idEntreprise;
}
