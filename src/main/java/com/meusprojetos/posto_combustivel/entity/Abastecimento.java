package com.meusprojetos.posto_combustivel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_abastecimento")
@Getter
@Setter
@NoArgsConstructor
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_abastecimento")
    private LocalDateTime dataAbastecimento;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "bomba_combustivel_id")
    private BombaDeCombustivel bombaDeCombustivel;
}
