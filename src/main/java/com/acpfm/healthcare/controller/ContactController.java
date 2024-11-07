package com.acpfm.healthcare.controller;

import com.acpfm.healthcare.model.Contact;
import com.acpfm.healthcare.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> listContacts(){
        return contactService.getAllContacts();
    }

    //Endpoint para inserir um novo registro de contato de utente no sistema
    @PostMapping("/register")
    public Contact registerContact(@RequestBody Contact contact, Model model){
        contactService.registerContact(contact);
        //model.addAttribute("contact",contactService.searchContactsUtente(contact.getNumUtente()));
        //return "fragments/contact-list :: contactList";
        return contact;
    }

    //Endpoint para pesquisar dados de contato de um utente
    @PostMapping("/search/{numUtente}")
    public List<Contact> listContactsUtente(@PathVariable Integer numUtente, Model model){
        List<Contact> contacts = contactService.searchContactsUtente(numUtente);
        return contacts;
    }

    //Endpoint para atualizar registo de acessos do utilizador. É obrigatório passar o parâmetro id do registo
    @PutMapping("/update/{id}")
    public ResponseEntity<Contact> updateContato(@PathVariable Long id, @RequestBody Contact contactos){
        Contact updateContatos = contactService.updateContacto(id, contactos);
        return updateContatos != null ? ResponseEntity.ok(updateContatos) : ResponseEntity.notFound().build();
    }

    // Endpoint para deletar um contato de um utente
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContato(@PathVariable Long id) {
        contactService.deleteContato(id);
        return ResponseEntity.noContent().build();
    }
}
