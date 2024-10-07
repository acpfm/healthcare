package com.acpfm.healthcare.repository;

import com.acpfm.healthcare.model.UnidadesAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadesAtendimentoRepository extends JpaRepository<UnidadesAtendimento,Long> {
    List<UnidadesAtendimento> findByNomeContaining(String name);

}
