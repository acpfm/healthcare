package com.acpfm.healthcare.service;


import com.acpfm.healthcare.model.AcessosUtilizador;
import com.acpfm.healthcare.repository.AcessosUtilizadorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public AcessosUtilizador updateAcessosUtilizador(Long id, AcessosUtilizador updatedAcessos) {
        return acessosUtilizadorRepository.findById(id).map(existingAcessos -> {
            copyNonNullProperties(updatedAcessos, existingAcessos);
            return acessosUtilizadorRepository.save(existingAcessos);
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
