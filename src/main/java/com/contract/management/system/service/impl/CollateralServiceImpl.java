package com.contract.management.system.service.impl;

import com.contract.management.system.dao.CollateralDao;
import com.contract.management.system.model.CollateralMapper;
import com.contract.management.system.model.dto.CollateralDto;
import com.contract.management.system.model.entity.CollateralEntity;
import com.contract.management.system.model.entity.ProductEntity;
import com.contract.management.system.repository.ProductRepository;
import com.contract.management.system.service.CollateralService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class CollateralServiceImpl implements CollateralService
{
    private final CollateralDao collateralDao;
    @Override
    public CollateralEntity save(CollateralDto dto)
    {
        CollateralEntity collateral = CollateralMapper.INSTANCE.toEntity(dto);
        ProductEntity product = new ProductEntity();
        product.setId(dto.getProductId());
        collateral.setProduct(product);

        return collateralDao.save(collateral);
    }

    @Override
    public void deleteById(int id)
    {
        collateralDao.deleteById(id);
    }

    @Override
    public CollateralEntity findById(int id)
    {
        return collateralDao.findById(id);
    }

    @Override
    public List<CollateralEntity> findAll()
    {
        return collateralDao.findAll();
    }
}
