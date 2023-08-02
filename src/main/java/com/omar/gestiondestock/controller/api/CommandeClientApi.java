package com.omar.gestiondestock.controller.api;

import com.omar.gestiondestock.dto.CommandeClientDto;
import com.omar.gestiondestock.utils.Constants;
import io.swagger.annotations.Api;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.APP_ROOT + "/commandesclients")
public interface CommandeClientApi {

    @PostMapping(Constants.APP_ROOT + "/commandesclients/create")
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto);

    @GetMapping(Constants.APP_ROOT + "/commandesclients/{idCommandeClient}")
    ResponseEntity<CommandeClientDto> findById(Integer idCommandeClient);

    @GetMapping(Constants.APP_ROOT + "/commandesclients/{codeCommandeClient}")
    ResponseEntity<CommandeClientDto> findByCode(@PathVariable("codeCommandeClient") String code);

    @GetMapping(Constants.APP_ROOT+"/commmandesclients/all")
    ResponseEntity<List<CommandeClientDto>> findAll();

    @DeleteMapping(Constants.APP_ROOT +"/commandesclients/delete/{idCommandeClient}")
    ResponseEntity delete(@PathVariable("idCommandeClient") Integer id);
}
