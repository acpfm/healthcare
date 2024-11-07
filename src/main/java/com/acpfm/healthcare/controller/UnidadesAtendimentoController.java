package com.acpfm.healthcare.controller;


import com.acpfm.healthcare.model.Professional;
import com.acpfm.healthcare.model.UnidadesAtendimento;
import com.acpfm.healthcare.service.UnidadesAtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidadesatend")
public class UnidadesAtendimentoController {
    @Autowired
    UnidadesAtendimentoService unidadesAtendimentoService;

    //Endpoint para registar uma nova unidade de atendimento.
    @PostMapping("/register")
    public UnidadesAtendimento registerUnidadesAtendimento(@RequestBody UnidadesAtendimento unidadesAtendimento, Model model){
        unidadesAtendimentoService.registerUnidadesAtendimento(unidadesAtendimento);
        return unidadesAtendimento;
    }

    //Endpoint para listar as unidades de atendimento registadas a partir de um nome.
    @PostMapping("/search")
    public String searchUnidadesAtendimento(@RequestParam String nome, Model model){
        List<UnidadesAtendimento> unidadesAtendimento = unidadesAtendimentoService.searchUnidadesAtendimento(nome);
        model.addAttribute("unidadesAtendimento",unidadesAtendimento);
        return "fragments/unidadesAtendimento-list :: unidadesAtendimentoList";
    }

    //Endpoint para atualizar registo da unidade de atendimento. É obrigatório passar o parâmetro id do registo
    @PutMapping("/update/{id}")
    public ResponseEntity<UnidadesAtendimento> updateUnidAtend(@PathVariable Long id, @RequestBody UnidadesAtendimento unidAtend){
        UnidadesAtendimento updateUnidAtend = unidadesAtendimentoService.updateUnidadesAtend(id, unidAtend);
        return updateUnidAtend != null ? ResponseEntity.ok(updateUnidAtend) : ResponseEntity.notFound().build();
    }
}
