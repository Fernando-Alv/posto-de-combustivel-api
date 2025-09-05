package com.meusprojetos.posto_combustivel.dto;

public record BombaDeCombustivelResponseDTO(
        Long id,
        String nome,
        TipoDeCombustivelDTO tipoDeCombustivelDTO
) {
}
