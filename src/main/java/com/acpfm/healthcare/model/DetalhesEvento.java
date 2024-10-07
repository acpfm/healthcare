package com.acpfm.healthcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "detalhesevento")
public class DetalhesEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idevento")
    private Integer idEvento;

    @Column(name = "subjetivo", columnDefinition = "TEXT")
    private String subjetivo;

    @Column(name = "objetivo", columnDefinition = "TEXT")
    private String objetivo;

    @Column(name = "avaliacao", columnDefinition = "TEXT")
    private String avaliacao;

    @Column(name = "plano", columnDefinition = "TEXT")
    private String plano;
}
