package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.Patient;
import com.acpfm.healthcare.repository.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    //Verifica se existe contatos e encontrando o registro com base no id passado faz a atualização
    public Patient updatePatient(Long id, Patient updatedPatient) {
        return patientRepository.findById(id).map(existingPatients -> {
            copyNonNullProperties(updatedPatient, existingPatients);
            return patientRepository.save(existingPatients);
        }).orElse(null);
    }

    // Método auxiliar para copiar apenas propriedades não nulas
    private void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : src.getPropertyDescriptors()) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        return emptyNames.toArray(new String[0]);
    }
}
