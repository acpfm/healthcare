package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.DetalhesEvento;
import com.acpfm.healthcare.model.Evento;
import com.acpfm.healthcare.repository.DetalhesEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalhesEventoService {
    @Autowired
    private final DetalhesEventoRepository detalhesEventoRepository;

    public DetalhesEventoService(DetalhesEventoRepository detalhesEventoRepository) {
        this.detalhesEventoRepository = detalhesEventoRepository;
    }

    public DetalhesEvento registerDetalhesEvento(DetalhesEvento detalhesEvento){
        return detalhesEventoRepository.save(detalhesEvento);
    }

    public List<DetalhesEvento> searchEventosNumUtente(Integer IdEvento){
        return detalhesEventoRepository.findByIdEvento(IdEvento);
    }
}
