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
@Table(name = "professional")
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_mecanog")
    private Integer numMecanog;

    @Column(name = "nprofiss")
    private String nprofiss;

    @Column(name = "Nomecompleto")
    private String nomeCompleto;

    @Column(name = "NomeClin")
    private String nomeClin;

    @Column(name = "DtNasc")
    private Date dtNasc;

    @Column(name = "Status")
    private String status;

    @Column(name = "CodEspecialidade")
    private Integer codEspecialidade;

    @Column(name = "GrupoProfissional")
    private Integer grupoProfissional;

    @Column(name = "DtRegisto")
    private Date dtRegisto;

    @Column(name = "DtModificacao")
    private Date dtModificacao;

    @Column(name = "Telefone")
    private String telefone;
}
