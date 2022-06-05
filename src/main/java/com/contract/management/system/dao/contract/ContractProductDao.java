package com.contract.management.system.dao.contract;

import com.contract.management.system.model.contract.entity.ContractProductEntity;

import java.util.List;

public interface ContractProductDao
{
    ContractProductEntity save(ContractProductEntity entity);
    void deleteById(long id);
    ContractProductEntity findById(long id);
    List<ContractProductEntity> findAll();
}
