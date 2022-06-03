package com.contract.management.system.dao;

import com.contract.management.system.entity.CollateralEntity;

public interface CollateralDao
{
	CollateralEntity save(CollateralEntity entity);
	CollateralEntity findById(int id);
}
