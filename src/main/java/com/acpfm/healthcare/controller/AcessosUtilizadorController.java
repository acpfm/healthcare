package com.acpfm.healthcare.controller;


import com.acpfm.healthcare.model.AcessosUtilizador;
import com.acpfm.healthcare.service.AcessosUtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
    public String listaAcessos(Model model){
        List<AcessosUtilizador> acessos = acessosUtilizadorService.getAllAcessos();
        model.addAttribute("numMecanog",acessos);
        return "fragments/acessosuser-list :: AcessosList";
    }

    //Endpoint para listar os acessos de um utilizador através do Num. Mecanografico
    @PostMapping("/search/{numMecanog}")
    public List<AcessosUtilizador> searchAcessosUtilizador(@PathVariable Integer numMecanog, Model model){
        List<AcessosUtilizador> acessos = acessosUtilizadorService.searchAcessosUtilizador(numMecanog);
        model.addAttribute("numMecanog",acessos);
        return acessos;
    }

    //Endpoint para atualizar registo de acessos do utilizador
    @PutMapping("/update/{id}")
    public ResponseEntity<AcessosUtilizador> updateAcessosUtilizador(@PathVariable Long id, @RequestBody AcessosUtilizador acessos){
        AcessosUtilizador updateAcessos = acessosUtilizadorService.updateAcessosUtilizador(id,acessos);
        return updateAcessos != null ? ResponseEntity.ok(updateAcessos) : ResponseEntity.notFound().build();
    }
}
