package com.contract.management.system.dao;

import com.contract.management.system.model.entity.ProductEntity;

import java.util.List;

public interface ProductDao
{
    ProductEntity save(ProductEntity entity);
    void deleteById(int id);
    ProductEntity findById(int id);
    List<ProductEntity> findAll();
}
