package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.Contact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ContactServiceTest {
    @Autowired
    private ContactService contactService;

    @Test
    void testSaveContact(){
        //Cria contato do utente
        Contact contact = new Contact();
        contact.setNumUtente(123908445);
        contact.setIdTpContacto(2);
        contact.setValor("hpotter@email.com");
        contact.setObservacao("contato principal");

        //Salvar contato do utente
        Contact savedContato = contactService.registerContact(contact);

        //Confere se o ID foi gerado e os dados salvos
        assertNotNull(savedContato.getId());
        assertEquals(123908445,savedContato.getNumUtente());
        assertEquals(2,savedContato.getIdTpContacto());
        assertEquals("hpotter@email.com",savedContato.getValor());
        assertEquals("contato principal",savedContato.getObservacao());
    }
    
}
