package com.contract.management.system.dao.contract;

import com.contract.management.system.model.contract.entity.ContractCollateralEntity;

import java.util.List;
import java.util.Set;

public interface ContractCollateralDao
{
    ContractCollateralEntity save(ContractCollateralEntity entity);
    void deleteById(long id);
    ContractCollateralEntity findById(long id);
    List<ContractCollateralEntity> findByIdIn(Set<Long> ids);
    List<ContractCollateralEntity> findByContractProductId(long contractProductId);
}
