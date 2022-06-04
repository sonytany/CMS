package com.contract.management.system.service.impl;

import com.contract.management.system.dao.CollateralDao;
import com.contract.management.system.dao.ProductDao;
import com.contract.management.system.model.CollateralMapper;
import com.contract.management.system.model.ProductMapper;
import com.contract.management.system.model.dto.CollateralDto;
import com.contract.management.system.model.dto.ProductDto;
import com.contract.management.system.model.entity.CollateralEntity;
import com.contract.management.system.model.entity.ProductEntity;
import com.contract.management.system.repository.ProductRepository;
import com.contract.management.system.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService
{
    private final ProductDao productDao;
    @Override
    public ProductEntity save(ProductDto productDto)
    {
        return productDao.save(ProductMapper.INSTANCE.toEntity(productDto));
    }

    @Override
    public void deleteById(int id)
    {
        productDao.deleteById(id);
    }

    @Override
    public ProductEntity findById(int id)
    {
        return productDao.findById(id);
    }

    @Override
    public List<ProductEntity> findAll()
    {
        return productDao.findAll();
    }
}
