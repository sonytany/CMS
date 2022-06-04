package com.contract.management.system.repository;

import com.contract.management.system.model.contract.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<ContractEntity, Integer>
{}
