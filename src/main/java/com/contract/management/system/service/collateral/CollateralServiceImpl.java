package com.contract.management.system.service.collateral;

import com.contract.management.system.dao.collateral.CollateralDao;
import com.contract.management.system.exception.BaseException;
import com.contract.management.system.model.collateral.CollateralMapper;
import com.contract.management.system.model.collateral.dto.CollateralDto;
import com.contract.management.system.model.collateral.entity.CollateralEntity;
import com.contract.management.system.model.product.entiry.ProductEntity;
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
    public CollateralDto save(CollateralDto dto) throws BaseException
    {
        CollateralEntity collateral = CollateralMapper.INSTANCE.toEntity(dto);
        ProductEntity product = new ProductEntity();
        product.setId(dto.getProductId());
        collateral.setProduct(product);
        collateralDao.save(collateral);
        return CollateralMapper.INSTANCE.toDto(collateralDao.findById(dto.getCollateralId()));
    }

    @Override
    public void deleteById(int id) throws BaseException
    {
        collateralDao.deleteById(id);
    }

    @Override
    public CollateralDto findById(int id) throws BaseException
    {
        return CollateralMapper.INSTANCE.toDto(collateralDao.findById(id));
    }

    @Override
    public List<CollateralDto> findAll() throws BaseException
    {
        return CollateralMapper.INSTANCE.toDtos(collateralDao.findAll());
    }
}
