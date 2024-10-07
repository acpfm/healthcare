package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.Evento;
import com.acpfm.healthcare.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    @Autowired
    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento registerEvento(Evento evento){
        return eventoRepository.save(evento);
    }

    public List<Evento> getAllEventos(){
        return eventoRepository.findAll();
    }

    public List<Evento> searchEventosNumUtente(Integer numUtente){
        return eventoRepository.findByNumUtente(numUtente);
    }
}
