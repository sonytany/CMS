package com.contract.management.system.dao.collateral;

import com.contract.management.system.model.collateral.entity.CollateralEntity;

import java.util.List;

public interface CollateralDao
{
	CollateralEntity save(CollateralEntity entity);
	void deleteById(long id);
	CollateralEntity findById(long id);
	List<CollateralEntity> findAll();

	List<CollateralEntity> findByIdIn(long[] ids);
}
