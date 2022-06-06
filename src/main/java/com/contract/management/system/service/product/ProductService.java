package com.contract.management.system.service.product;

import com.contract.management.system.model.product.dto.ProductAddDto;
import com.contract.management.system.model.product.dto.ProductDto;

import java.util.List;

public interface ProductService
{
    ProductDto addProduct(ProductAddDto dto);
    ProductDto updateProduct(ProductDto dto);
    void deleteById(long id);
    ProductDto findById(long id);
    List<ProductDto> findAll();
}
