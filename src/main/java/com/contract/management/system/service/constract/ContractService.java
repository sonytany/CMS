package com.contract.management.system.service.constract;

import com.contract.management.system.model.contract.dto.ContractAddDto;
import com.contract.management.system.model.contract.dto.ContractDto;

import java.util.List;

public interface ContractService
{
    ContractDto addContract(ContractAddDto dto);
    void delete(int id);
    ContractDto findById(int id);
    List<ContractDto> findByCode(String Code);
    List<ContractDto> findAll();
}
