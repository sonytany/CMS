package com.contract.management.system.dao.collateral;

import com.contract.management.system.model.collateral.entity.CollateralEntity;
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

	@Override
	public List<CollateralEntity> findByIdIn(int[] ids)
	{
		return this.collateralRepository.findByIdIn(ids);
	}
}
