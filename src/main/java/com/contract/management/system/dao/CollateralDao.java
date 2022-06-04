package com.contract.management.system.dao;

import com.contract.management.system.model.entity.CollateralEntity;

import java.util.List;

public interface CollateralDao
{
	CollateralEntity save(CollateralEntity entity);
	void deleteById(int id);
	CollateralEntity findById(int id);
	List<CollateralEntity> findAll();
}
