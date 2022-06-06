package com.contract.management.system.controller;

import com.contract.management.system.exception.BaseException;
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

    @GetMapping("/contract/{id}")
    public ResponseEntity<ContractDto> getContract(@Valid long id) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(contractService.findById(id));
    }

    @GetMapping("/contract/{code}")
    public ResponseEntity<ContractDto> getContract(@Valid String code) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(contractService.findByCode(code));
    }

    @PutMapping("/contract")
    public ResponseEntity<ContractDto> putContract(@Valid @RequestBody ContractAddDto dto) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(contractService.addContract(dto));
    }

    @PostMapping("contract")
    public ResponseEntity<ContractDto> postContract(@Valid @RequestBody ContractUpdateDto dto) throws BaseException
    {
        return ResponseEntity.status(HttpStatus.OK).body(contractService.updateContract(dto));
    }

//    @PostMapping("/product")
//    public ProductDTO postProduct(ProductDTO dto)
//    {
//        return prodService.update(dto);
//    }


}
