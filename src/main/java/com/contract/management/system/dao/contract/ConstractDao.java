package com.contract.management.system.dao.contract;

import com.contract.management.system.model.contract.entity.ContractEntity;

import java.util.List;

public interface ConstractDao
{
    ContractEntity save(ContractEntity entity);
    void deleteById(int id);
    ContractEntity findById(int id);
    List<ContractEntity> findAll();
}
