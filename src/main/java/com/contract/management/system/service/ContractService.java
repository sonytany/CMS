package com.contract.management.system.service;

import com.contract.management.system.model.dto.CollateralDto;

import java.util.List;

public interface ContractService
{
    CollateralDto add(CollateralDto dto);
    void delete(int id);
    CollateralDto getById(int id);
    List<CollateralDto> getByName(String name);
    List<CollateralDto> getAll();
}
