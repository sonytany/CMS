package com.contract.management.system.service.constract;

import com.contract.management.system.exception.BaseException;
import com.contract.management.system.model.contract.dto.ContractAddDto;
import com.contract.management.system.model.contract.dto.ContractDto;

import java.util.List;

public interface ContractService
{
    ContractDto addContract(ContractAddDto dto) throws BaseException;
    void delete(long id);
    ContractDto findById(long id);
    List<ContractDto> findByCode(String Code);
    List<ContractDto> findAll();
}
