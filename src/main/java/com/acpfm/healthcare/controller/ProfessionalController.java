package com.acpfm.healthcare.controller;

import com.acpfm.healthcare.model.Professional;
import com.acpfm.healthcare.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    //Endpoint para atualizar registo do profissional. É obrigatório passar o parâmetro id do registo
    @PutMapping("/update/{id}")
    public ResponseEntity<Professional> updateProfessional(@PathVariable Long id, @RequestBody Professional professionals){
        Professional updateProfessional = professionalService.updateProfessional(id, professionals);
        return updateProfessional != null ? ResponseEntity.ok(updateProfessional) : ResponseEntity.notFound().build();
    }
}
