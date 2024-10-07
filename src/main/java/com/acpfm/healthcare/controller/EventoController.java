package com.acpfm.healthcare.controller;

import com.acpfm.healthcare.model.Evento;
import com.acpfm.healthcare.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evento")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> listEventos(){
        return eventoService.getAllEventos();
    }

    @PostMapping("/register")
    public Evento registerEvento(@RequestBody Evento evento, Model model){
        eventoService.registerEvento(evento);
        return evento;
    }

    @PostMapping("/search")
    public List<Evento> listEventosNumUtente(@RequestParam Integer numUtente){
        return eventoService.searchEventosNumUtente(numUtente);
    }
}
