package com.meusprojetos.posto_combustivel.mapper;

import com.meusprojetos.posto_combustivel.dto.TipoDeCombustivelDTO;
import com.meusprojetos.posto_combustivel.entity.TipoDeCombustivel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TipoDeCombustivelMapper {

    @Mapping(target = "id", ignore = true)
    TipoDeCombustivel toEntity(TipoDeCombustivelDTO dto);

    TipoDeCombustivelDTO toDto(TipoDeCombustivel entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(TipoDeCombustivelDTO dto, @MappingTarget TipoDeCombustivel entity);

    List<TipoDeCombustivelDTO> toDtoList(List<TipoDeCombustivel> entities);
}
