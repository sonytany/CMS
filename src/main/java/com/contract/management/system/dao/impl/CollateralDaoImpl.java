package com.contract.management.system.dao.impl;

import com.contract.management.system.dao.CollateralDao;
import com.contract.management.system.model.entity.CollateralEntity;
import com.contract.management.system.repository.CollateralRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CollateralDaoImpl implements CollateralDao
{
	private final CollateralRepository collateralRepository;

	@Override
	public CollateralEntity save(CollateralEntity entity)
	{
		return this.collateralRepository.save(entity);
	}

	@Override
	public void deleteById(int id)
	{
		this.collateralRepository.deleteById(id);
	}

	@Override
	public CollateralEntity findById(int id)
	{
		return this.collateralRepository.findById(id).orElse(null);
	}

	@Override
	public List<CollateralEntity> findAll()
	{
		return this.collateralRepository.findAll();
	}
}
