package com.contract.management.system.service;

import com.contract.management.system.dto.CollateralDTO;
import com.contract.management.system.entity.Collateral;

import java.util.ArrayList;
import java.util.List;

public interface CollateralService
{
    CollateralDTO add(CollateralDTO dto);
    void delete(int id);
    CollateralDTO getById(int id);
    List<CollateralDTO> getByName(String name);
    List<CollateralDTO> getAll();

    default Collateral dtoToEntityByADD(CollateralDTO dto)
    {
        Collateral collarteral = Collateral.builder()
                .code(dto.getCode())
                .name(dto.getName())
                .insurableMoney(dto.getInsurableMoney())
                .standardMoney(dto.getStandardMoney())
                .build();

        return collarteral;
    }
    default Collateral dtoToEntity(CollateralDTO dto)
    {
        Collateral collarteral = Collateral.builder()
                .id(dto.getId())
                .code(dto.getCode())
                .name(dto.getName())
                .insurableMoney(dto.getInsurableMoney())
                .standardMoney(dto.getStandardMoney())
                .build();

        return collarteral;
    }

    default CollateralDTO entityToDto(Collateral entity)
    {
        CollateralDTO dto = CollateralDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .insurableMoney(entity.getInsurableMoney())
                .standardMoney(entity.getStandardMoney())
                .productId(entity.getProduct().getId())
                .build();

        return dto;
    }

    default List<Collateral> dtosToEntitys(List<CollateralDTO> dtos)
    {
        List<Collateral> entitys = new ArrayList<>();

        dtos.forEach((dto) -> {
            entitys.add(dtoToEntity(dto));
        });

        return entitys;
    }

    default List<CollateralDTO> entitysToDtos(List<Collateral> entitys)
    {
        List<CollateralDTO> dtos = new ArrayList<>();

        entitys.forEach((entity) -> {
            dtos.add(entityToDto(entity));
        });

        return dtos;
    }
}
