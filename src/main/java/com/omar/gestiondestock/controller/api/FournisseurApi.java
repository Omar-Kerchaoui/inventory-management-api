package com.omar.gestiondestock.controller.api;

import com.omar.gestiondestock.dto.FournisseurDto;
import com.omar.gestiondestock.utils.Constants;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.FOURNISSEUR_ENDPOINT)
public interface FournisseurApi {

    @PostMapping(Constants.FOURNISSEUR_ENDPOINT + "/create")
    FournisseurDto save(@RequestBody FournisseurDto dto);

    @GetMapping(Constants.FOURNISSEUR_ENDPOINT+ "/{fournisseuId}")
    FournisseurDto findById(@PathVariable("fournisseurId") Integer id);

    @GetMapping(Constants.FOURNISSEUR_ENDPOINT +"/all")
    List<FournisseurDto> findAll();

    @DeleteMapping(Constants.FOURNISSEUR_ENDPOINT +"/delete/{idFournisseur}")
    void delete(@PathVariable("idFournisseur") Integer id);
}
