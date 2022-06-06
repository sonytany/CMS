package com.contract.management.system.dao.collateral;

import com.contract.management.system.model.collateral.entity.CollateralEntity;

import java.util.List;
import java.util.Set;

public interface CollateralDao
{
	CollateralEntity save(CollateralEntity entity);
	void deleteById(long id);
	CollateralEntity findById(long id);
	CollateralEntity findByCode(String code);
	List<CollateralEntity> findAll();
	List<CollateralEntity> findByIdIn(Set<Long> ids);
}
