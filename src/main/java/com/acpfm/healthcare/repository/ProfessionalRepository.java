package com.acpfm.healthcare.repository;

import com.acpfm.healthcare.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    List<Professional> findByNomeCompleto(String nome);
}
