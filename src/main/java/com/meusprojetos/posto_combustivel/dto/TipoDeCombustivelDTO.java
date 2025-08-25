package com.meusprojetos.posto_combustivel.dto;

import java.math.BigDecimal;

public record TipoDeCombustivelDTO(
        Long id,
        String nome,
        BigDecimal precoPorLitro
) {}
