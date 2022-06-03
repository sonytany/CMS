package com.contract.management.system.repository;

import com.contract.management.system.entity.Collateral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollateralRepository extends JpaRepository<Collateral, Integer>
{
    List<Collateral> findByNameLike(String name);
}
