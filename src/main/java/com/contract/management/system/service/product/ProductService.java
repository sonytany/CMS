package com.contract.management.system.service.product;

import com.contract.management.system.model.product.dto.ProductDto;

import java.util.List;

public interface ProductService
{
    ProductDto save(ProductDto dto);
    void deleteById(long id);
    ProductDto findById(long id);
    List<ProductDto> findAll();
}
