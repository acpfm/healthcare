package com.acpfm.healthcare.controller;

import com.acpfm.healthcare.model.Contact;
import com.acpfm.healthcare.model.Patient;
import com.acpfm.healthcare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    //Endpoint para listar os pacientes. Lista sem filtro.
    @GetMapping
    public String listPatients(Model model){
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients",patients);
        return "patients";
    }

    //Endpoint para registar um novo paciente.
    @PostMapping("/register")
    public Patient registerPatient(@RequestBody Patient patient, Model model){
        patientService.registerPatient(patient);
        //model.addAttribute("patients",patientService.getAllPatients());
        //return "fragments/patient-list :: patientList";
        return patient;
    }

    //Endpoint para pesquisar um paciente a partir de seu nome
    @PostMapping("/search")
    public String searchPatients(@RequestParam String nome, Model model){
        List<Patient> patients = patientService.searchPatients(nome);
        model.addAttribute("patients",patients);
        return "fragments/patient-list :: patientList";
    }

    //Endpoint para atualizar registo de utente. É obrigatório passar o parâmetro id do registo
    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patients){
        Patient updatePatients = patientService.updatePatient(id, patients);
        return updatePatients != null ? ResponseEntity.ok(patients) : ResponseEntity.notFound().build();
    }
}
