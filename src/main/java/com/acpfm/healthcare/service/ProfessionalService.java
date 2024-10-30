package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.Patient;
import com.acpfm.healthcare.model.Professional;
import com.acpfm.healthcare.repository.AcessosUtilizadorRepository;
import com.acpfm.healthcare.repository.ProfessionalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    //Verifica se existe profissional e encontrando o registro com base no id passado faz a atualização
    public Professional updateProfessional(Long id, Professional updatedProfessional) {
        return professionalRepository.findById(id).map(existingProfessional -> {
            copyNonNullProperties(updatedProfessional, existingProfessional);
            return professionalRepository.save(existingProfessional);
        }).orElse(null);
    }

    // Método auxiliar para copiar apenas propriedades não nulas
    private void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : src.getPropertyDescriptors()) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        return emptyNames.toArray(new String[0]);
    }
}
