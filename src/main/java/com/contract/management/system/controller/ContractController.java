package com.contract.management.system.controller;

import com.contract.management.system.model.contract.dto.ContractAddDto;
import com.contract.management.system.model.contract.dto.ContractDto;
import com.contract.management.system.model.contract.dto.ContractTempDto;
import com.contract.management.system.model.contract.dto.ContractUpdateDto;
import com.contract.management.system.service.constract.ContractService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class ContractController
{
    private final ContractService contractService;

    @ApiOperation(value = "계약정보 조회 API", notes="계약정보를 ID값으로 조회한다.")
    @GetMapping("/contract/{id}")
    public ResponseEntity<ContractDto> getContract(@PathVariable @Valid long id) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(contractService.findById(id));
    }

    @ApiOperation(value = "계약정보 조회 API", notes="계약정보 CODE(계약번호)값으로 조회한다.")
    @GetMapping("/contract/code/{code}")
    public ResponseEntity<ContractDto> getContract(@PathVariable @Valid String code) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(contractService.findByCode(code));
    }

    @ApiOperation(value = "계약정보 조회 API ", notes="새로운 상품을 생성한다.")
    @PostMapping("/contract/price")
    public ResponseEntity<ContractTempDto> postContractPrice(@Valid @RequestBody ContractAddDto dto) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(contractService.findTotalPrice(dto));
    }

    @ApiOperation(value = "계약 생성 API", notes="새로운 계약을 생성한다.")
    @PutMapping("/contract")
    public ResponseEntity<ContractDto> putContract(@Valid @RequestBody ContractAddDto dto) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(contractService.addContract(dto));
    }

    @ApiOperation(value = "계약정보 수정 API", notes="계약정보를 수정한다. 담보, 계약기간, 계약상태를 변경한다.")
    @PostMapping("contract")
    public ResponseEntity<ContractDto> postContract(@Valid @RequestBody ContractUpdateDto dto) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(contractService.updateContract(dto));
    }
}
