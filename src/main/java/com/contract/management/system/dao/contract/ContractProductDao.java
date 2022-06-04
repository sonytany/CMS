package com.contract.management.system.dao.contract;

import com.contract.management.system.model.contract.entity.ContractProductEntity;

import java.util.List;

public interface ContractProductDao
{
    ContractProductEntity save(ContractProductEntity entity);
    void deleteById(int id);
    ContractProductEntity findById(int id);
    List<ContractProductEntity> findAll();
}
