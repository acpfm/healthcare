package com.acpfm.healthcare.controller;


import com.acpfm.healthcare.model.UnidadesAtendimento;
import com.acpfm.healthcare.service.UnidadesAtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidadesatend")
public class UnidadesAtendimentoController {
    @Autowired
    UnidadesAtendimentoService unidadesAtendimentoService;

    @PostMapping("/register")
    public UnidadesAtendimento registerUnidadesAtendimento(@RequestBody UnidadesAtendimento unidadesAtendimento, Model model){
        unidadesAtendimentoService.registerUnidadesAtendimento(unidadesAtendimento);
        return unidadesAtendimento;
    }

    @PostMapping("/search")
    public String searchUnidadesAtendimento(@RequestParam String nome, Model model){
        List<UnidadesAtendimento> unidadesAtendimento = unidadesAtendimentoService.searchUnidadesAtendimento(nome);
        model.addAttribute("unidadesAtendimento",unidadesAtendimento);
        return "fragments/unidadesAtendimento-list :: unidadesAtendimentoList";
    }

}
