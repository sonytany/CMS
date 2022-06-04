package com.contract.management.system.controller;

import com.contract.management.system.model.product.dto.ProductDto;
import com.contract.management.system.service.product.ProductService;
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
        return prodService.save(dto);
    }

    @PostMapping("/product")
    public ProductDto postProduct(@RequestBody ProductDto dto)
    {
        return prodService.save(dto);
    }

    @DeleteMapping("/product")
    public void deleteCollateralProduct(int id)
    {
        prodService.deleteById(id);
    }

    @GetMapping("/product")
    public ProductDto getProduct(int id)
    {
        return prodService.findById(id);
    }

    @GetMapping("/products")
    public List<ProductDto> getCollateralProducts()
    {
        return prodService.findAll();
    }
}
