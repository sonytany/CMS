package com.contract.management.system.repository;

import com.contract.management.system.entity.Collateral;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CollateralRepository extends CrudRepository<Collateral, Integer>
{
    List<Collateral> findByNameLike(String name);
}
