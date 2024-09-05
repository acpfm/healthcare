package com.test.controller;

import com.acpfm.healthcare.controller.PatientController;
import com.acpfm.healthcare.model.Patient;
import com.acpfm.healthcare.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PatientControllerTest {
    @Mock
    private PatientService patientService;

    @Mock
    private Model model;

    @InjectMocks
    private PatientController patientController;

    public PatientControllerTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListPatients(){
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient());
        when(patientService.getAllPatients()).thenReturn(patients);

        String viewName = patientController.listPatients(model);

        verify(patientService,times(1)).getAllPatients();
        verify(model,times(1)).addAttribute("patients",patients);
        assertEquals("patients",viewName);
    }

    @Test
    void testRegisterPatient(){
        Patient patient = new Patient();
        List<Patient> patients = new ArrayList<>();
        patients.add(patient);

        when(patientService.getAllPatients()).thenReturn(patients);

        String viewName = patientController.registerPatient(patient,model);

        verify(patientService,times(1)).registerPatient(patient);
        verify(model,times(1)).addAttribute("patients",patients);
        assertEquals("fragments/patient-list :: patientList", viewName);
    }

    @Test
    void testSearchPatients(){

        String nome = "Harry Potter";
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient());

        when(patientService.searchPatients(nome)).thenReturn(patients);

        String viewName = patientController.searchPatients(nome,model);

        verify(patientService, times(1)).searchPatients(nome);
        verify(model,times(1)).addAttribute("patients",patients);
        assertEquals("fragments/pacients :: patientList", viewName);
    }
}
