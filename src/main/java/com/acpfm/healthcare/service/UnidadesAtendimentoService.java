package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.UnidadesAtendimento;
import com.acpfm.healthcare.repository.UnidadesAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadesAtendimentoService {
    private final UnidadesAtendimentoRepository unidadesAtendimentoRepository;

    @Autowired
    public UnidadesAtendimentoService(UnidadesAtendimentoRepository unidAtendimentoRepository) {
        this.unidadesAtendimentoRepository = unidAtendimentoRepository;
    }

    public UnidadesAtendimento registerUnidadesAtendimento(UnidadesAtendimento unidadesAtendimento) {
        return unidadesAtendimentoRepository.save(unidadesAtendimento);
    }

    public List<UnidadesAtendimento> searchUnidadesAtendimento(String nome) {
        return unidadesAtendimentoRepository.findByNomeContaining(nome);
    }

}
