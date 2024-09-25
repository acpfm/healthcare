package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.Contact;
import com.acpfm.healthcare.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceTest {
    @Autowired
    private PatientService patientService;
    private ContactService contactService;

    @Test
    void testSavePatient(){
        //Cria um novo utente
        Patient patient = new Patient();
        patient.setNome("Severus Snape");
        patient.setCodUnidade(1000001);
        patient.setNumUtente(918273645);

        //Salvar o utente
        Patient savedPatient = patientService.registerPatient(patient);

        //Confere se o ID foi gerado e os dados salvos
        assertNotNull(savedPatient.getId());
        assertEquals("Severus Snape",savedPatient.getNome());
        assertEquals(1000001,savedPatient.getCodUnidade());
        assertEquals(918273645,savedPatient.getNumUtente());
    }
}
