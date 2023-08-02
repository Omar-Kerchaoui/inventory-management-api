package com.omar.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Adresse {

    @Column(name = "adresse1")
    private String adresse1;

    @Column (name = "adresse2")
    private String adresse2;

    @Column (name = "ville")
    private String ville;

    @Column (name = "codepostale")
    private String codePostale;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @Column (name = "pays")
    private String pays;
}
