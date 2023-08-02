package com.omar.gestiondestock.repository;

import com.omar.gestiondestock.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommadeClientRepository extends JpaRepository<LigneCommandeClient,Integer> {
}
