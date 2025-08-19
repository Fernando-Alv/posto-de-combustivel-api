package com.meusprojetos.posto_combustivel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_bomba_de_combustivel")
@Getter
@Setter
@NoArgsConstructor
public class BombaDeCombustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "combustivel_id")
    private TipoDeCombustivel tipoDeCombustivel;

}
