package com.acpfm.healthcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "unidadesatendimento")
public class UnidadesAtendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tp_unidadeatendimento")
    private Integer tpUnidadeAtendimento;

    @Column(name = "cod_unidadesaude")
    private Integer codUnidadeSaude;

    @Column(name = "morada")
    private String morada;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "dt_registo")
    private Date dtRegisto;

    @Column(name = "dt_alteracao")
    private Date dtAlteracao;
}
