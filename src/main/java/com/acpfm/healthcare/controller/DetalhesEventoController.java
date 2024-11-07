package com.acpfm.healthcare.controller;

import com.acpfm.healthcare.model.DetalhesEvento;
import com.acpfm.healthcare.service.DetalhesEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalhesevento")
public class DetalhesEventoController {
    @Autowired
    private DetalhesEventoService detalhesEventoService;

    //Endpoint para inserir os detalhes do evento que ocorrem no momento do atendimento.
    @PostMapping("/register")
    public DetalhesEvento registerEvento(@RequestBody DetalhesEvento detalhesEvento, Model model){
        detalhesEventoService.registerDetalhesEvento(detalhesEvento);
        return detalhesEvento;
    }

    //Endpoint que permite listar os dados registados de um evento a partir do seu Id.
    @PostMapping("/search")
    public List<DetalhesEvento> listEventosIdEvento(@RequestParam Integer IdEvento){
        return detalhesEventoService.searchEventosNumUtente(IdEvento);
    }

    //Endpoint para atualizar os detalhes do registo de um evento. É obrigatório passar o parâmetro id do registo
    @PutMapping("/update/{id}")
    public ResponseEntity<DetalhesEvento> updateDetalhesEvento(@PathVariable Long id, @RequestBody DetalhesEvento updateDetalhesEvento){
        DetalhesEvento updateDetEvento = detalhesEventoService.updateUser(id, updateDetalhesEvento);
        return updateDetEvento != null ? ResponseEntity.ok(updateDetalhesEvento) : ResponseEntity.notFound().build();
    }
}
