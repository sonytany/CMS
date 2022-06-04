package com.contract.management.system.repository;

import com.contract.management.system.model.contract.entity.ContractProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractProductRepository extends JpaRepository<ContractProductEntity, Integer>
{}
