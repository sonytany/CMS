package com.contract.management.system.controller;

import com.contract.management.system.dto.ProductDTO;
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
    public ProductDTO putProduct(ProductDTO dto)
    {
        return prodService.add(dto);
    }

    @PostMapping("/product")
    public ProductDTO postProduct(ProductDTO dto)
    {
        return prodService.update(dto);
    }

    @DeleteMapping("/product")
    public void deleteProduct(int id)
    {
        prodService.delete(id);
    }

    @GetMapping("/product")
    public ProductDTO getProduct(int id)
    {
        return prodService.getById(id);
    }

    @GetMapping("/product/name")
    public List<ProductDTO> getProduct(String name)
    {
        return prodService.getByName(name);
    }

    @GetMapping("/products")
    public List<ProductDTO> getProducts()
    {
        return prodService.getAll();
    }
}
