package com.contract.management.system.dao.impl;

import com.contract.management.system.dao.CollateralDao;
import com.contract.management.system.entity.CollateralEntity;
import com.contract.management.system.repository.CollateralRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CollateralDaoImpl implements CollateralDao
{
	private final CollateralRepository collateralRepository;

	@Override
	public CollateralEntity save(CollateralEntity entity)
	{
		this.collateralRepository.save(entity);
		return entity;
	}

	@Override
	public CollateralEntity findById(int id)
	{
		return collateralRepository.findById(id).orElse(null);
	}
}
