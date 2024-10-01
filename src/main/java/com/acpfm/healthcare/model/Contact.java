package com.acpfm.healthcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contactos_utente")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_utente")
    private Integer numUtente;

    @Column(name = "id_tp_contacto")
    private Integer idTpContacto;

    @Column(name = "valor")
    private String valor;

    @Column(name = "observacao")
    private String observacao;
}
