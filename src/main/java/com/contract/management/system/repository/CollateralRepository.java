package com.contract.management.system.repository;

import com.contract.management.system.model.collateral.entity.CollateralEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollateralRepository extends JpaRepository<CollateralEntity, Integer>
{
    List<CollateralEntity> findByIdIn(int[] ids);
}
