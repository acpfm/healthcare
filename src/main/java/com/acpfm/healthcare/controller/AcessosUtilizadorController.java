package com.acpfm.healthcare.controller;


import com.acpfm.healthcare.model.AcessosUtilizador;
import com.acpfm.healthcare.service.AcessosUtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acessosUtilizador")
public class AcessosUtilizadorController {

    @Autowired
    private AcessosUtilizadorService acessosUtilizadorService;

    @GetMapping
    public List<AcessosUtilizador> listaAcessos(){
        return acessosUtilizadorService.getAllAcessos();
    }

    @PostMapping("/search")
    public List<AcessosUtilizador> searchAcessosUtilizador(@RequestParam Integer numMecanog){
        return acessosUtilizadorService.searchAcessosUtilizador(numMecanog);
    }

    @PostMapping("/register")
    public AcessosUtilizador registerAcessosUtilizador(@RequestBody AcessosUtilizador acessos, Model model){
        acessosUtilizadorService.registerAcessosUtilizador(acessos);
        //model.addAttribute("acessosUtilizador",acessosUtilizadorService.registerAcessosUtilizador(acessos.getNmecanogUtilizador()));
        return acessos;
    }
}
