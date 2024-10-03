package com.acpfm.healthcare.controller;

import com.acpfm.healthcare.model.Professional;
import com.acpfm.healthcare.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professionals")
public class ProfessionalController {
    @Autowired
    ProfessionalService professionalService;

    @GetMapping
    public String listProfessionals(Model model){
        List<Professional> professional = professionalService.getAllProfessionals();
        model.addAttribute("professionals",professional);
        return "professionals";
    }

    @PostMapping("/register")
    public Professional registerProfessional(@RequestBody Professional professional, Model model){
        professionalService.registerProfessional(professional);
        //model.addAttribute("patients",patientService.getAllPatients());
        //return "fragments/patient-list :: patientList";
        return professional;
    }

    @PostMapping("/search")
    public String searchProfessional(@RequestParam String nome, Model model){
        List<Professional> professional = professionalService.searchProfessionals(nome);
        model.addAttribute("professionals",professional);
        return "fragments/professional-list :: professionalList";
    }
}
