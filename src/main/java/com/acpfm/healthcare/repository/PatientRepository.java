package com.acpfm.healthcare.repository;

import com.acpfm.healthcare.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface PatientRepository extends JpaRepository<Patient,Long>{
    List<Patient> findByNameContaining(String nome);
}
