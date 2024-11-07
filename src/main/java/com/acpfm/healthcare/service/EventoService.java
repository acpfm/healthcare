package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.Evento;
import com.acpfm.healthcare.repository.EventoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    //Verifica se existe evento marcado e encontrando o registro com base no id passado faz a atualização
    public Evento updateUser(Long id, Evento updatedEvento) {
        return eventoRepository.findById(id).map(existingEvento -> {
            copyNonNullProperties(updatedEvento, existingEvento);
            return eventoRepository.save(existingEvento);
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
