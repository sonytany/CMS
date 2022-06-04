package com.contract.management.system.controller;

import com.contract.management.system.model.contract.dto.ContractDto;
import com.contract.management.system.service.constract.ContractService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ContractController
{
    private final ContractService contractService;
//    @PutMapping("/product")
//    public ProductDTO putProduct(ProductDTO dto)
//    {
//        return prodService.add(dto);
//    }
//
//    @PostMapping("/product")
//    public ProductDTO postProduct(ProductDTO dto)
//    {
//        return prodService.update(dto);
//    }
//
//    @DeleteMapping("/product")
//    public void deleteProduct(int id)
//    {
//        prodService.delete(id);
//    }
//
    @GetMapping("/contract")
    public ContractDto getContract(int id)
    {
        return contractService.findById(id);
    }
//
//    @GetMapping("/product/name")
//    public List<ContractDto> getContract(String name)
//    {
//        return prodService.getByName(name);
//    }
//
//    @GetMapping("/products")
//    public List<ProductDTO> getProducts()
//    {
//        return prodService.getAll();
//    }
}
