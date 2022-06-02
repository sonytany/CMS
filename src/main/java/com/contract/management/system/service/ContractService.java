package com.contract.management.system.service;

import com.contract.management.system.dto.CollateralDTO;

import java.util.List;

public interface ContractService
{
    CollateralDTO add(CollateralDTO dto);
    void delete(int id);
    CollateralDTO getById(int id);
    List<CollateralDTO> getByName(String name);
    List<CollateralDTO> getAll();
}
