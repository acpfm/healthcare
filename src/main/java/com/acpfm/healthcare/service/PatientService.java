package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.Patient;
import com.acpfm.healthcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient registerPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatient(Long id){
        return patientRepository.findById(id);
    }

    public List<Patient> searchPatients(String nome){
        return patientRepository.findByNomeContaining(nome);
    }

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
}
