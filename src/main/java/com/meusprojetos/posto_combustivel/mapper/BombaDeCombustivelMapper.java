package com.meusprojetos.posto_combustivel.mapper;

import com.meusprojetos.posto_combustivel.dto.BombaDeCombustivelRequestDTO;
import com.meusprojetos.posto_combustivel.dto.BombaDeCombustivelResponseDTO;
import com.meusprojetos.posto_combustivel.entity.BombaDeCombustivel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",uses = {TipoDeCombustivelMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BombaDeCombustivelMapper {

    @Mapping(target = "tipoDeCombustivel.id" , source = "tipoDeCombustivelId")
    BombaDeCombustivel toEntity(BombaDeCombustivelRequestDTO dto);

    @Mapping(target = "tipoDeCombustivelDTO", source = "tipoDeCombustivel")
    BombaDeCombustivelResponseDTO toDto(BombaDeCombustivel entity);

    @Mapping(source = "tipoDeCombustivelId", target = "tipoDeCombustivel.id")
    void updateEntityFromDto(BombaDeCombustivelRequestDTO dto, @MappingTarget BombaDeCombustivel entity);

    List<BombaDeCombustivelResponseDTO> toDtoList(List<BombaDeCombustivel> entities);
}
