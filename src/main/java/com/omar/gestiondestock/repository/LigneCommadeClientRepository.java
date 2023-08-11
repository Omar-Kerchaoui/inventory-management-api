package com.omar.gestiondestock.repository;

import com.omar.gestiondestock.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommadeClientRepository extends JpaRepository<LigneCommandeClient,Integer> {

     List<LigneCommandeClient> findAllByCommandeClientId(Integer id);

     List<LigneCommandeClient> findAllByArticleId(Integer id);

}
