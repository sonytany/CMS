package com.contract.management.system.dao.contract;

import com.contract.management.system.model.contract.entity.ContractEntity;

import java.util.List;

public interface ContractDao
{
    ContractEntity save(ContractEntity entity);
    ContractEntity findById(long id);
    ContractEntity findByCode(String code);
    List<ContractEntity> findByEndDateGreaterThan(String expireDate);
}
