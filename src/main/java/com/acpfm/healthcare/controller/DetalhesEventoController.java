package com.acpfm.healthcare.controller;

import com.acpfm.healthcare.model.DetalhesEvento;
import com.acpfm.healthcare.service.DetalhesEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalhesevento")
public class DetalhesEventoController {
    @Autowired
    private DetalhesEventoService detalhesEventoService;

    @PostMapping("/register")
    public DetalhesEvento registerEvento(@RequestBody DetalhesEvento detalhesEvento, Model model){
        detalhesEventoService.registerDetalhesEvento(detalhesEvento);
        return detalhesEvento;
    }

    @PostMapping("/search")
    public List<DetalhesEvento> listEventosIdEvento(@RequestParam Integer IdEvento){
        return detalhesEventoService.searchEventosNumUtente(IdEvento);
    }
}
