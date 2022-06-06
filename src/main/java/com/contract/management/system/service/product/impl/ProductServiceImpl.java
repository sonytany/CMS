package com.contract.management.system.service.product.impl;

import com.contract.management.system.dao.collateral.CollateralDao;
import com.contract.management.system.dao.product.ProductDao;
import com.contract.management.system.model.collateral.entity.CollateralEntity;
import com.contract.management.system.model.product.ProductMapper;
import com.contract.management.system.model.product.dto.ProductAddDto;
import com.contract.management.system.model.product.dto.ProductDto;
import com.contract.management.system.model.product.entiry.ProductEntity;
import com.contract.management.system.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService
{
    private final ProductDao productDao;
    private final CollateralDao collateralDao;

    @Override
    public ProductDto addProduct(ProductAddDto productAddDto)
    {
        return ProductMapper.INSTANCE.toDto(productDao.save(ProductMapper.INSTANCE.toEntity(productAddDto)));
    }
    @Override
    public ProductDto updateProduct(ProductDto productDto)
    {
        return ProductMapper.INSTANCE.toDto(productDao.save(ProductMapper.INSTANCE.toUpdateEntity(productDto)));
    }

    @Override
    public void deleteById(long id)
    {
        ProductEntity product = productDao.findById(id);
        List<CollateralEntity> collateralEntities = product.getCollaterals();

        for(CollateralEntity collaterals : collateralEntities)
            collateralDao.deleteById(collaterals.getId());

        productDao.deleteById(id);
    }

    @Override
    public ProductDto findById(long id)
    {
        return ProductMapper.INSTANCE.toDto(productDao.findById(id));
    }

    @Override
    public List<ProductDto> findAll()
    {
        return ProductMapper.INSTANCE.toDtos(productDao.findAll());
    }
}
