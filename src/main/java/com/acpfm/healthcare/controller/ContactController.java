package com.acpfm.healthcare.controller;

import com.acpfm.healthcare.model.Contact;
import com.acpfm.healthcare.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/register")
    public String registerContact(@ModelAttribute Contact contact, Model model){
        contactService.registerContact(contact);
        model.addAttribute("contact",contactService.searchContactsUtente(contact.getNumUtente()));
        return "fragments/contact-list :: contactList";
    }

    @PostMapping("/search")
    public List<Contact> listContactsUtente(@RequestParam Integer numUtente){
        return contactService.searchContactsUtente(numUtente);
    }
}
