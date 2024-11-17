package com.acpfm.healthcare.controller;

import com.acpfm.healthcare.model.Evento;
import com.acpfm.healthcare.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evento")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    //Endpoint para listar todos os eventos existentes. Não tem filtros, é uma lista geral.
    @GetMapping
    public List<Evento> listEventos(){
        return eventoService.getAllEventos();
    }

    //Endpoint para inserir um novo evento.
    @PostMapping("/register")
    public Evento registerEvento(@RequestBody Evento evento, Model model){
        eventoService.registerEvento(evento);
        return evento;
    }

    //Endpoint para pesquisar um evento de um determinado utente.
    @PostMapping("/search/{numUtente}")
    public List<Evento> listEventosNumUtente(@PathVariable Integer numUtente, Model model){
        List<Evento> eventos = eventoService.searchEventosNumUtente(numUtente);
        return eventos;
    }

    //Endpoint para atualizar registo de um evento. É obrigatório passar o parâmetro id do registo
    @PutMapping("/update/{id}")
    public ResponseEntity<Evento> updateEvento(@PathVariable Long id, @RequestBody Evento updateEventos){
        Evento updateEvento = eventoService.updateUser(id, updateEventos);
        return updateEvento != null ? ResponseEntity.ok(updateEventos) : ResponseEntity.notFound().build();
    }
}
