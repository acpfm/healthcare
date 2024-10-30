package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.AcessosUtilizador;
import com.acpfm.healthcare.model.Contact;
import com.acpfm.healthcare.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ContactService {

    @Autowired
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact registerContact(Contact contact){
        return contactRepository.save(contact);
    }

    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    public List<Contact> searchContactsUtente(Integer numUtente){
        return contactRepository.findByNumUtente(numUtente);
    }

    //Verifica se existe contatos e encontrando o registro com base no id passado faz a atualização
    public Contact updateContacto(Long id, Contact updatedContato) {
        return contactRepository.findById(id).map(existingContatos -> {
            copyNonNullProperties(updatedContato, existingContatos);
            return contactRepository.save(existingContatos);
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

    // Método para deletar um registo de contato
    public void deleteContato(Long id) {
        contactRepository.deleteById(id);
    }
}
