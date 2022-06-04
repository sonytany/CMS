package com.contract.management.system.dao.collateral;

import com.contract.management.system.model.collateral.entity.CollateralEntity;

import java.util.List;

public interface CollateralDao
{
	CollateralEntity save(CollateralEntity entity);
	void deleteById(int id);
	CollateralEntity findById(int id);
	List<CollateralEntity> findAll();

	List<CollateralEntity> findByIdIn(int[] ids);
}
