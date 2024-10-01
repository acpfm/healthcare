package com.acpfm.healthcare.controller;

import com.acpfm.healthcare.model.Patient;
import com.acpfm.healthcare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public String listPatients(Model model){
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients",patients);
        return "patients";
    }

    @PostMapping("/register")
    public Patient registerPatient(@RequestBody Patient patient, Model model){
        patientService.registerPatient(patient);
        //model.addAttribute("patients",patientService.getAllPatients());
        //return "fragments/patient-list :: patientList";
        return patient;
    }

    @PostMapping("/search")
    public String searchPatients(@RequestParam String nome, Model model){
        List<Patient> patients = patientService.searchPatients(nome);
        model.addAttribute("patients",patients);
        return "fragments/patient-list :: patientList";
    }
}
