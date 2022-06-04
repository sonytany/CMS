package com.contract.management.system.dao.product;

import com.contract.management.system.model.product.entiry.ProductEntity;

import java.util.List;

public interface ProductDao
{
    ProductEntity save(ProductEntity entity);
    void deleteById(int id);
    ProductEntity findById(int id);
    List<ProductEntity> findAll();
}
