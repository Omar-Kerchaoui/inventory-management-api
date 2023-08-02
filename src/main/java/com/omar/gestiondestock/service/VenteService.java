package com.omar.gestiondestock.service;

import com.omar.gestiondestock.dto.CommandeClientDto;
import com.omar.gestiondestock.dto.VenteDto;

import java.util.List;

public interface VenteService {

    VenteDto save(VenteDto dto);

    VenteDto findById(Integer id);
    VenteDto findByCode(String code);

    List<VenteDto> findAll();

    void delete(Integer id);
}
