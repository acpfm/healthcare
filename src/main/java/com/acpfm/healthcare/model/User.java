package com.acpfm.healthcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Utilizadores")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_mecanog")
    private Integer num_mecanog;

    @Column(name = "id_perfil")
    private Integer id_perfil;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "num_cedula")
    private Integer num_cedula;

    @Column(name = "status")
    private Integer status;
}
