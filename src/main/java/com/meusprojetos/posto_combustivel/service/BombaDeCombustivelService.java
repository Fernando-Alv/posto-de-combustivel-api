package com.meusprojetos.posto_combustivel.service;

import com.meusprojetos.posto_combustivel.dto.BombaDeCombustivelRequestDTO;
import com.meusprojetos.posto_combustivel.dto.BombaDeCombustivelResponseDTO;
import com.meusprojetos.posto_combustivel.entity.BombaDeCombustivel;
import com.meusprojetos.posto_combustivel.entity.TipoDeCombustivel;
import com.meusprojetos.posto_combustivel.exception.RecursoNaoEncontradoException;
import com.meusprojetos.posto_combustivel.mapper.BombaDeCombustivelMapper;
import com.meusprojetos.posto_combustivel.repository.BombaDeCombustivelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BombaDeCombustivelService {

    private final BombaDeCombustivelRepository bombaDeCombustivelRepository;

    private final BombaDeCombustivelMapper bombaDeCombustivelMapper;

    private final TipoDeCombustivelService tipoDeCombustivelService;

    public BombaDeCombustivelResponseDTO create(BombaDeCombustivelRequestDTO dto) {

        BombaDeCombustivel entity = bombaDeCombustivelMapper.toEntity(dto);

        TipoDeCombustivel tipo = tipoDeCombustivelService.getEntityById(dto.tipoDeCombustivelId());
        entity.setTipoDeCombustivel(tipo);

        BombaDeCombustivel salva = bombaDeCombustivelRepository.save(entity);

        return bombaDeCombustivelMapper.toDto(salva);
    }

    public BombaDeCombustivelResponseDTO findById(Long id) {

        BombaDeCombustivel entity = getEntityById(id);
        return bombaDeCombustivelMapper.toDto(entity);
    }

    public List<BombaDeCombustivelResponseDTO> findAll() {

        List<BombaDeCombustivel> entities = bombaDeCombustivelRepository.findAll();
        return bombaDeCombustivelMapper.toDtoList(entities);
    }

    public BombaDeCombustivelResponseDTO update(Long id, BombaDeCombustivelRequestDTO dto) {

        BombaDeCombustivel entity = getEntityById(id);

        tipoDeCombustivelService.getEntityById(dto.tipoDeCombustivelId());
        bombaDeCombustivelMapper.updateEntityFromDto(dto, entity);

        BombaDeCombustivel atualizada = bombaDeCombustivelRepository.save(entity);

        return bombaDeCombustivelMapper.toDto(atualizada);
    }

    public void detele(Long id) {
        BombaDeCombustivel entity = getEntityById(id);
        bombaDeCombustivelRepository.delete(entity);
    }

    private BombaDeCombustivel getEntityById(Long id) {

        return bombaDeCombustivelRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Bomba de combustível não encontrado com o id: " + id));

    }
}
