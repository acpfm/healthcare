package com.test.service;

import com.acpfm.healthcare.model.Patient;
import com.acpfm.healthcare.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientService patientService;

    @Test
    void testSavePatient(){
        //Cria um novo utente
        Patient patient = new Patient();
        patient.setNome("Harry Potter");
        patient.setCod_unidade(1000001);
        patient.setNum_utente(123908445);

        //Salvar o utente
        Patient savedPatient = patientService.registerPatient(patient);

        //Confere se o ID foi gerado e os dados salvos
        assertNotNull(savedPatient.getId());
        assertEquals("Harry Potter",savedPatient.getNome());
        assertEquals(1000001,savedPatient.getCod_unidade());
        assertEquals(123908445,savedPatient.getNum_utente());
    }
}
