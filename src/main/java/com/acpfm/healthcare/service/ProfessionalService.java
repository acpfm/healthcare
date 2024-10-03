package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.Professional;
import com.acpfm.healthcare.repository.AcessosUtilizadorRepository;
import com.acpfm.healthcare.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalService {

    private final ProfessionalRepository professionalRepository;

    @Autowired
    public ProfessionalService(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }

    public Professional registerProfessional(Professional professional){
        return professionalRepository.save(professional);
    }

    public List<Professional> searchProfessionals(String nome){
        return professionalRepository.findByNomeCompleto(nome);
    }

    public List<Professional> getAllProfessionals(){
        return professionalRepository.findAll();
    }
}
