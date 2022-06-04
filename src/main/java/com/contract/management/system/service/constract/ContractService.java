package com.contract.management.system.service.constract;

import com.contract.management.system.model.contract.dto.ContractDto;

import java.util.List;

public interface ContractService
{
    ContractDto save(ContractDto dto);
    void delete(int id);
    ContractDto findById(int id);
    List<ContractDto> findByCode(String Code);
    List<ContractDto> findAll();
}
