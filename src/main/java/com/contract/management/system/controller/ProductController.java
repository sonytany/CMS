package com.contract.management.system.controller;

import com.contract.management.system.model.product.dto.ProductAddDto;
import com.contract.management.system.model.product.dto.ProductDto;
import com.contract.management.system.service.product.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class ProductController
{
    private final ProductService prodService;

    @ApiOperation(value = "상품생성", notes="새로운 상품을 생성한다.")
    @PutMapping("/product")
    public ResponseEntity<ProductDto> putProduct(@RequestBody ProductAddDto dto)
    {
        return ResponseEntity.status(HttpStatus.OK).body(prodService.addProduct(dto));
    }

    @ApiOperation(value = "상품수정", notes="상품정보를 수정한다.")
    @PostMapping("/product")
    public ResponseEntity<ProductDto> postProduct(@RequestBody ProductDto dto)
    {
        return ResponseEntity.status(HttpStatus.OK).body(prodService.updateProduct(dto));
    }

    @ApiOperation(value = "상품삭제", notes="상품을 제거한다.")
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable long id)
    {
        prodService.deleteById(id);
    }

    @ApiOperation(value = "상품조회 ID", notes="상품을 ID로 조회한다.")
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(prodService.findById(id));
    }

    @ApiOperation(value = "전체상품조회", notes="전체 상품목록을 조회한다.")
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getCollateralProducts()
    {
        return ResponseEntity.status(HttpStatus.OK).body(prodService.findAll());
    }
}
