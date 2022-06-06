package com.contract.management.system.repository;

import com.contract.management.system.model.collateral.entity.CollateralEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CollateralRepository extends JpaRepository<CollateralEntity, Long>
{
    List<CollateralEntity> findByIdIn(Set<Long> ids);
    CollateralEntity findByCode(String code);
}
