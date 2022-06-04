package com.contract.management.system.repository;

import com.contract.management.system.model.collateral.entity.CollateralEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollateralRepository extends JpaRepository<CollateralEntity, Integer>
{}
