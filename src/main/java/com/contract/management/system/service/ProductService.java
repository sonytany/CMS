package com.contract.management.system.service;

import com.contract.management.system.model.dto.CollateralDto;
import com.contract.management.system.model.dto.ProductDto;
import com.contract.management.system.model.entity.CollateralEntity;
import com.contract.management.system.model.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public interface ProductService
{
    ProductEntity save(ProductDto dto);
    void deleteById(int id);
    ProductEntity findById(int id);
    List<ProductEntity> findAll();
}
