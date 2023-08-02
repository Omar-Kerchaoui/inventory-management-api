package com.omar.gestiondestock.controller.api;

import com.omar.gestiondestock.dto.UtilisateurDto;
import com.omar.gestiondestock.utils.Constants;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.UTILISATEUR_ENDPOINT)
public interface UtilisateurApi {

    @PostMapping(Constants.UTILISATEUR_ENDPOINT +"/create")
    UtilisateurDto save(@RequestBody UtilisateurDto dto);

    @GetMapping(Constants.UTILISATEUR_ENDPOINT + "/{idUtilisateur}")
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(Constants.UTILISATEUR_ENDPOINT + "/all")
    List<UtilisateurDto> findAll();

    @DeleteMapping(Constants.UTILISATEUR_ENDPOINT +"/delete/{idUtilisateur}")
    void delete(Integer id);
}
