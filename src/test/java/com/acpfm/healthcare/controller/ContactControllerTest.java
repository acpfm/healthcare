package com.acpfm.healthcare.controller;

import com.acpfm.healthcare.model.Contact;
import com.acpfm.healthcare.service.ContactService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ContactControllerTest {
    /*
    * @Mock
    private ContactService contactService;

    @Mock
    private Model model;

    @InjectMocks
    private ContactController contactController;

    public ContactControllerTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterContactsUtentes(){
        Contact contact = new Contact();
        List<Contact> contacts = new ArrayList<>();
        contacts.add(contact);

        when(contactService.searchContactsUtente(contact.getNumUtente())).thenReturn(contacts);

        String viewContact = contactController.registerContact(contact,model);

        verify(contactService,times(1)).registerContact(contact);
        verify(model,times(1)).addAttribute("contacts",contact);
        assertEquals("fragments/contact-list :: contactList", viewContact);
    }
    * */

}
