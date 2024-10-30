package com.acpfm.healthcare.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dtIniVigencia;

    @Column(name = "dt_fim_vigencia")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dtFimVigencia;

}
