package com.contract.management.system.service;

import com.contract.management.system.dto.CollateralDto;

import java.util.List;

public interface CollateralService
{
//    CollateralDto add(CollateralDto dto);
//    void delete(int id);
    CollateralDto findById(int id);
//    List<CollateralDto> getByName(String name);
//    List<CollateralDto> getAll();

//    default List<Collateral> dtosToEntitys(List<CollateralDTO> dtos)
//    {
//        List<Collateral> entitys = new ArrayList<>();
//
//        dtos.forEach((dto) -> {
//            entitys.add(dtoToEntity(dto));
//        });
//
//        return entitys;
//    }
//
//    default List<CollateralDTO> entitysToDtos(List<Collateral> entitys)
//    {
//        List<CollateralDTO> dtos = new ArrayList<>();
//
//        entitys.forEach((entity) -> {
//            dtos.add(entityToDto(entity));
//        });
//
//        return dtos;
//    }
}
