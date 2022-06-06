package com.contract.management.system.repository;

import com.contract.management.system.model.contract.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository<ContractEntity, Long>
{
    ContractEntity findByCode(String code);
    List<ContractEntity> findByEndDateGreaterThan(String expireDate);
}
