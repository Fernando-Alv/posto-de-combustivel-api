package com.meusprojetos.posto_combustivel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_tipos_de_combustivel")
@Getter
@Setter
@NoArgsConstructor
public class TipoDeCombustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco_por_litro", nullable = false)
    private BigDecimal precoPorLitro;
}
