package com.acpfm.healthcare.repository;

import com.acpfm.healthcare.model.AcessosUtilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcessosUtilizadorRepository extends JpaRepository<AcessosUtilizador,Long> {
    List<AcessosUtilizador> findBynmecanogUtilizador(Integer numMecanog);
}
