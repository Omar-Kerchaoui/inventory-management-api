package com.omar.gestiondestock.repository;

import com.omar.gestiondestock.model.LigneCommandeClient;
import com.omar.gestiondestock.model.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur,Integer> {

    List<LigneCommandeFournisseur>  findAllByCommandeFournisseurId(Integer id);
}
