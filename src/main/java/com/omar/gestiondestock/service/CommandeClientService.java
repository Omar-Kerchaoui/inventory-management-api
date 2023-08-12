package com.omar.gestiondestock.service;

import com.omar.gestiondestock.dto.ClientDto;
import com.omar.gestiondestock.dto.CommandeClientDto;
import com.omar.gestiondestock.dto.LigneCommandeClientDto;
import com.omar.gestiondestock.model.EtatCommande;
import com.omar.gestiondestock.model.LigneCommandeClient;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeClientService {

    CommandeClientDto save(CommandeClientDto dto);

    CommandeClientDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande);

    CommandeClientDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite);

    CommandeClientDto updateClient (Integer idCommande, Integer idClient);

    CommandeClientDto updateArticle (Integer idCommande, Integer idLigneCommande, Integer idArticle);

    // delete article ==> delete ligneCommandeClient
    CommandeClientDto deleteArticle(Integer idCommande, Integer idLigneCommande);

    List<LigneCommandeClientDto> findAllLigneCommandeClientByCommandeClientId(Integer idCommandeClient);

    CommandeClientDto findById(Integer id);

    CommandeClientDto findByCode(String code);

    List<CommandeClientDto> findAll();

    void delete(Integer id);
}
