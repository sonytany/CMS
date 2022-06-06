package com.contract.management.system.service.constract;

import com.contract.management.system.exception.BaseException;
import com.contract.management.system.model.contract.dto.ContractAddDto;
import com.contract.management.system.model.contract.dto.ContractDto;
import com.contract.management.system.model.contract.dto.ContractUpdateDto;

public interface ContractService
{
    ContractDto findById(long id) throws BaseException;
    ContractDto findByCode(String Code) throws BaseException;
    ContractDto addContract(ContractAddDto dto) throws BaseException;
    ContractDto updateContract(ContractUpdateDto dto) throws BaseException;
}
