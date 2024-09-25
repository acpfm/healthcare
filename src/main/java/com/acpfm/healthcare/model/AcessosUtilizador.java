package com.acpfm.healthcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "acessos_utilizador")
public class AcessosUtilizador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nmecanog_utilizador")
    private Integer nmecanogUtilizador;

    @Column(name = "cod_unidade")
    private Integer codUnidade;

    @Column(name = "dt_ini_vigencia")
    private Integer dtIniVigencia;

    @Column(name = "dt_fim_vigencia")
    private Integer dtFimVigencia;
}
