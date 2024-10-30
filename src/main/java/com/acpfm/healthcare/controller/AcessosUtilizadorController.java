package com.acpfm.healthcare.controller;


import com.acpfm.healthcare.model.AcessosUtilizador;
import com.acpfm.healthcare.service.AcessosUtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acessosUtilizador")
public class AcessosUtilizadorController {

    private final AcessosUtilizadorService acessosUtilizadorService;

    @Autowired
    public AcessosUtilizadorController(AcessosUtilizadorService acessosUtilizadorService) {
        this.acessosUtilizadorService = acessosUtilizadorService;
    }

    //Endpoint para inserir um novo registro de utilizador do sistema
    @PostMapping("/register")
    public ResponseEntity<AcessosUtilizador> registerAcessosUtilizador(@RequestBody AcessosUtilizador acessos){
        AcessosUtilizador savedAcessosUtilizador = acessosUtilizadorService.registerAcessosUtilizador(acessos);
        return ResponseEntity.ok(savedAcessosUtilizador);
    }

    //Endpoint para listar todos os acessos de todos os utilizadores
    @GetMapping
    public List<AcessosUtilizador> listaAcessos(){
        return acessosUtilizadorService.getAllAcessos();
    }

    //Endpoint para listar os acessos de um utilizador através do Num. Mecanografico
    @PostMapping("/search")
    public List<AcessosUtilizador> searchAcessosUtilizador(@RequestParam Integer numMecanog){
        return acessosUtilizadorService.searchAcessosUtilizador(numMecanog);
    }

    //Endpoint para atualizar registo de acessos do utilizador
    @PutMapping("/update/{id}")
    public ResponseEntity<AcessosUtilizador> updateAcessosUtilizador(@PathVariable Long id, @RequestBody AcessosUtilizador acessos){
        AcessosUtilizador updateAcessos = acessosUtilizadorService.updateAcessosUtilizador(id,acessos);
        return updateAcessos != null ? ResponseEntity.ok(updateAcessos) : ResponseEntity.notFound().build();
    }
}
