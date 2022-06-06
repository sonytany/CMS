package com.contract.management.system.dao.collateral.impl;

import com.contract.management.system.dao.collateral.CollateralDao;
import com.contract.management.system.model.collateral.entity.CollateralEntity;
import com.contract.management.system.repository.CollateralRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
	public void deleteById(long id)
	{
		this.collateralRepository.deleteById(id);
	}

	@Override
	public CollateralEntity findById(long id)
	{
		return this.collateralRepository.findById(id).orElse(null);
	}

	@Override
	public CollateralEntity findByCode(String code)
	{
		return this.collateralRepository.findByCode(code);
	}

	@Override
	public List<CollateralEntity> findAll()
	{
		return this.collateralRepository.findAll();
	}

	@Override
	public List<CollateralEntity> findByIdIn(Set<Long> ids)
	{
		return this.collateralRepository.findByIdIn(ids);
	}
}
