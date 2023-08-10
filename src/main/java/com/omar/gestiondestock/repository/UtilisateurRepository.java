package com.omar.gestiondestock.repository;

import com.omar.gestiondestock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {

    @Query(value = "SELECT u FROM Utilisateur u WHERE u.email = :email")
    public Optional<Utilisateur> findUtilisateurByEmail(@Param("email") String email);
}
