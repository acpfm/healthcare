package com.acpfm.healthcare.repository;

import com.acpfm.healthcare.model.DetalhesEvento;
import com.acpfm.healthcare.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalhesEventoRepository extends JpaRepository<DetalhesEvento,Long> {
    List<DetalhesEvento> findByIdEvento(Integer IdEvento);

    List<DetalhesEvento> findBySubjetivo(String subjetivo);

    List<DetalhesEvento> findByObjetivo(String objetivo);

    List<DetalhesEvento> findByAvaliacao(String avaliacao);

    List<DetalhesEvento> findByPlano(String plano);
}
