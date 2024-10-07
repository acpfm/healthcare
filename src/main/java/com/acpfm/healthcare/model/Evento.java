package com.acpfm.healthcare.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tpevento")
    private Integer tpEvento;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dteventoag")
    private LocalDate dtEventoAg;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "hreventoag")
    private LocalTime hrEventoAg;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dteventoocor")
    private LocalDate dtEventoOcor;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "hreventoocor")
    private LocalTime hrEventoOcor;

    @Column(name = "idunidadeatend")
    private Integer idUnidadeAtend;

    @Column(name = "idprofiss")
    private Integer idProfiss;

    @Column(name = "numutente")
    private Integer numUtente;

    @Column(name = "status")
    private String status;

    @Column(name = "dtregisto")
    private LocalDateTime dtRegisto;

    @Column(name = "dtalteracao")
    private LocalDateTime dtAlteracao;

    @PrePersist
    protected void onCreate() {
        dtRegisto = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}
