package com.omar.gestiondestock.controller.api;

import com.omar.gestiondestock.dto.VenteDto;
import com.omar.gestiondestock.utils.Constants;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.VENTE_ENDPOINT)
public interface VenteApi {

    @PostMapping(Constants.VENTE_ENDPOINT + "/create")
    VenteDto save(@RequestBody VenteDto dto);

    @GetMapping(Constants.VENTE_ENDPOINT + "/{idVente}")
    VenteDto findById(@PathVariable("idVente") Integer id);

    @GetMapping(Constants.VENTE_ENDPOINT + "/{codeVente}")
    VenteDto findByCode(@PathVariable("codeVente") String code);

    @GetMapping(Constants.VENTE_ENDPOINT + "/all")
    List<VenteDto> findAll();

    @DeleteMapping(Constants.VENTE_ENDPOINT + "/delete/{idVente}")
    void delete(@PathVariable("idVente") Integer id);
}
