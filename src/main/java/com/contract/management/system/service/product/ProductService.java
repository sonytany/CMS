package com.contract.management.system.service.product;

import com.contract.management.system.model.product.dto.ProductDto;

import java.util.List;

public interface ProductService
{
    ProductDto save(ProductDto dto);
    void deleteById(int id);
    ProductDto findById(int id);
    List<ProductDto> findAll();
}
