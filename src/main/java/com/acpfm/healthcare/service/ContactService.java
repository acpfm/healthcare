package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.Contact;
import com.acpfm.healthcare.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
