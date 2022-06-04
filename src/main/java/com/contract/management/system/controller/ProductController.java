package com.contract.management.system.controller;

import com.contract.management.system.model.ProductMapper;
import com.contract.management.system.model.dto.ProductDto;
import com.contract.management.system.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ProductController
{
    private final ProductService prodService;

    @PutMapping("/product")
    public ProductDto putProduct(@RequestBody ProductDto dto)
    {
        return ProductMapper.INSTANCE.toDto(prodService.save(dto));
    }

    @PostMapping("/product")
    public ProductDto postProduct(@RequestBody ProductDto dto)
    {
        return ProductMapper.INSTANCE.toDto(prodService.save(dto));
    }

    @DeleteMapping("/product")
    public void deleteCollateralProduct(int id)
    {
        prodService.deleteById(id);
    }

    @GetMapping("/product")
    public ProductDto getProduct(int id)
    {
        return ProductMapper.INSTANCE.toDto(prodService.findById(id));
    }

    @GetMapping("/products")
    public List<ProductDto> getCollateralProducts()
    {
        return ProductMapper.INSTANCE.toDtos(prodService.findAll());
    }
}
