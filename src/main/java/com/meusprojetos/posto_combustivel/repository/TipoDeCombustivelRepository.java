package com.meusprojetos.posto_combustivel.repository;

import com.meusprojetos.posto_combustivel.entity.TipoDeCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDeCombustivelRepository extends JpaRepository<TipoDeCombustivel, Long> {
}
