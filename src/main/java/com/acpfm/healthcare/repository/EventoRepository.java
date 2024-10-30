package com.acpfm.healthcare.repository;

import com.acpfm.healthcare.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento,Long> {
    List<Evento> findByNumUtente(Integer NumUtente);

    List<Evento> findByIdProfiss(Integer idProfiss);

    List<Evento> findByIdUnidadeAtend(Integer idUnidadeAtend);
}
