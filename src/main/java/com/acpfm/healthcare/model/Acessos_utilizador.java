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
public class Acessos_utilizador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nmecanog_utilizador")
    private Integer nmecanog_utilizador;

    @Column(name = "cod_unidade")
    private Integer cod_unidade;

    @Column(name = "dt_ini_vigencia")
    private Integer dt_ini_vigencia;

    @Column(name = "dt_fim_vigencia")
    private Integer dt_fim_vigencia;
}
