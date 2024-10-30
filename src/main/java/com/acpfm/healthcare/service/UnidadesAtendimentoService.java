package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.UnidadesAtendimento;
import com.acpfm.healthcare.repository.UnidadesAtendimentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    //Verifica se existe profissional e encontrando o registro com base no id passado faz a atualização
    public UnidadesAtendimento updateUnidadesAtend(Long id, UnidadesAtendimento updatedUnidAtend) {
        return unidadesAtendimentoRepository.findById(id).map(existingUnidAtend -> {
            copyNonNullProperties(updatedUnidAtend, existingUnidAtend);
            return unidadesAtendimentoRepository.save(existingUnidAtend);
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
