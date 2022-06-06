package com.contract.management.system.controller;

import com.contract.management.system.model.contract.dto.ContractAddDto;
import com.contract.management.system.model.contract.dto.ContractDto;
import com.contract.management.system.model.contract.dto.ContractUpdateDto;
import com.contract.management.system.service.constract.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ContractController
{
    private final ContractService contractService;
    @PutMapping("/contract")
    public ResponseEntity<ContractDto> putContract(@Valid @RequestBody ContractAddDto dto) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(contractService.addContract(dto));
    }

//    @PostMapping("/product")
//    public ProductDTO postProduct(ProductDTO dto)
//    {
//        return prodService.update(dto);
//    }

    @PostMapping("contract")
    public ResponseEntity<ContractDto> postContract(@Valid @RequestBody ContractUpdateDto dto)
    {
        return null;
    }

    @GetMapping("/contract/{id}")
    public ContractDto getContract(@PathVariable long id) throws Exception
    {
        return contractService.findById(id);
    }
}
