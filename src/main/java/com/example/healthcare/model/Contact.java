package com.example.healthcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contactos_utente")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_utente")
    private Integer num_utente;

    @Column(name = "id_tp_contacto")
    private Integer id_tp_contacto;

    @Column(name = "valor")
    private Integer valor;

    @Column(name = "observacao")
    private Integer observacao;
}
