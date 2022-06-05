package com.contract.management.system.service.product.impl;

import com.contract.management.system.dao.product.ProductDao;
import com.contract.management.system.model.product.ProductMapper;
import com.contract.management.system.model.product.dto.ProductDto;
import com.contract.management.system.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService
{
    private final ProductDao productDao;
    @Override
    public ProductDto save(ProductDto productDto)
    {
        return ProductMapper.INSTANCE.toDto(productDao.save(ProductMapper.INSTANCE.toEntity(productDto)));
    }

    @Override
    public void deleteById(long id)
    {
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
