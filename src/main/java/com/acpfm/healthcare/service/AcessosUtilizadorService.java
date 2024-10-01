package com.acpfm.healthcare.service;


import com.acpfm.healthcare.model.AcessosUtilizador;
import com.acpfm.healthcare.repository.AcessosUtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AcessosUtilizadorService {
    private final AcessosUtilizadorRepository acessosUtilizadorRepository;

    @Autowired
    public AcessosUtilizadorService(AcessosUtilizadorRepository acessosUtilizadorRepository) {
        this.acessosUtilizadorRepository = acessosUtilizadorRepository;
    }

    public AcessosUtilizador registerAcessosUtilizador(AcessosUtilizador acessosUtilizador){
        return acessosUtilizadorRepository.save(acessosUtilizador);
    }

    public List<AcessosUtilizador> searchAcessosUtilizador(Integer numMecanog){
        return acessosUtilizadorRepository.findBynmecanogUtilizador(numMecanog);
    }

    public List<AcessosUtilizador> getAllAcessos(){
        return acessosUtilizadorRepository.findAll();
    }
}
