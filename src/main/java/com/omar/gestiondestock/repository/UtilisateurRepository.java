package com.omar.gestiondestock.repository;

import com.omar.gestiondestock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {

    public Optional<Utilisateur> findUtilisateurByEmail(String email);
}
