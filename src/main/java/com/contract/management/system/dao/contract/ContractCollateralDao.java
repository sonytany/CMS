package com.contract.management.system.dao.contract;

import com.contract.management.system.model.contract.entity.ContractCollateralEntity;

import java.util.List;

public interface ContractCollateralDao
{
    ContractCollateralEntity save(ContractCollateralEntity entity);
    void deleteById(int id);
    ContractCollateralEntity findById(int id);
    List<ContractCollateralEntity> findAll();
}
