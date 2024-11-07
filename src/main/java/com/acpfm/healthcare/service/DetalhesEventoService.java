package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.DetalhesEvento;
import com.acpfm.healthcare.repository.DetalhesEventoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    //Verifica se existe evento marcado e encontrando o registro com base no id passado faz a atualização
    public DetalhesEvento updateUser(Long id, DetalhesEvento updatedDetalhesEvento) {
        return detalhesEventoRepository.findById(id).map(existingDetEvento -> {
            copyNonNullProperties(updatedDetalhesEvento, existingDetEvento);
            return detalhesEventoRepository.save(existingDetEvento);
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
