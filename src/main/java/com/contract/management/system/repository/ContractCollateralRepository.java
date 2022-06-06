package com.contract.management.system.repository;

import com.contract.management.system.model.contract.entity.ContractCollateralEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ContractCollateralRepository extends JpaRepository<ContractCollateralEntity, Long>
{
    List<ContractCollateralEntity> findByIdIn(Set<Long> ids);
    List<ContractCollateralEntity> findByContractProductId(long contractProductId);
}
