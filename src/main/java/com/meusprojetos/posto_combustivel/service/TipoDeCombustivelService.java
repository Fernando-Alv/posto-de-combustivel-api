package com.meusprojetos.posto_combustivel.service;

import com.meusprojetos.posto_combustivel.dto.TipoDeCombustivelDTO;
import com.meusprojetos.posto_combustivel.entity.TipoDeCombustivel;
import com.meusprojetos.posto_combustivel.exception.RecursoNaoEncontradoException;
import com.meusprojetos.posto_combustivel.mapper.TipoDeCombustivelMapper;
import com.meusprojetos.posto_combustivel.repository.TipoDeCombustivelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoDeCombustivelService {

    private final TipoDeCombustivelRepository tipoDeCombustivelRepository;

    private final TipoDeCombustivelMapper tipoDeCombustivelMapper;

    public TipoDeCombustivelDTO create(TipoDeCombustivelDTO dto) {

        TipoDeCombustivel entity = tipoDeCombustivelMapper.toEntity(dto);
        TipoDeCombustivel salvo = tipoDeCombustivelRepository.save(entity);
        return tipoDeCombustivelMapper.toDto(salvo);
    }

    public TipoDeCombustivelDTO findById(Long id) {

        TipoDeCombustivel entity = getEntityById(id);
        return tipoDeCombustivelMapper.toDto(entity);
    }

    public List<TipoDeCombustivelDTO> findAll() {

        List<TipoDeCombustivel> entities = tipoDeCombustivelRepository.findAll();
        return tipoDeCombustivelMapper.toDtoList(entities);
    }

    public TipoDeCombustivelDTO update(Long id, TipoDeCombustivelDTO dto) {
        TipoDeCombustivel entity = getEntityById(id);

        tipoDeCombustivelMapper.updateEntityFromDto(dto, entity);

        TipoDeCombustivel atualizado = tipoDeCombustivelRepository.save(entity);
        return tipoDeCombustivelMapper.toDto(atualizado);
    }

    public void delete(Long id) {
        TipoDeCombustivel entity = getEntityById(id);

        tipoDeCombustivelRepository.delete(entity);
    }

    public TipoDeCombustivel getEntityById(Long id) {
        return tipoDeCombustivelRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Tipo de combustível não encontrado com o id: " + id));
    }
}
