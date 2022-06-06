package com.contract.management.system.controller;

import com.contract.management.system.model.collateral.dto.CollateralAddDto;
import com.contract.management.system.model.collateral.dto.CollateralDto;
import com.contract.management.system.service.collateral.CollateralService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class CollateralController
{
    private final CollateralService collService;
    @ApiOperation(value = "담보생성", notes="상품이 제공하는 담보를 생성한다.")
    @PutMapping("/collateral")
    public ResponseEntity<CollateralDto> putCollateral(@RequestBody CollateralAddDto dto) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(collService.addCollateral(dto));
    }

    @ApiOperation(value = "담보수정", notes="담보를 수정한다.")
    @PostMapping("/collateral")
    public ResponseEntity<CollateralDto> postCollateral(@RequestBody CollateralDto dto) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(collService.updateCollateral(dto));
    }

    @ApiOperation(value = "담보삭제", notes="담보를 삭제한다.")
    @DeleteMapping("/collateral/{id}")
    public void deleteCollateral(@PathVariable long id) throws Exception
    {
        collService.deleteById(id);
    }

    @ApiOperation(value = "담보조회 ID", notes="담보를 ID로 조회한다.")
    @GetMapping("/collateral/{id}")
    public ResponseEntity<CollateralDto> getCollateral(@PathVariable long id) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(collService.findById(id));
    }

    @ApiOperation(value = "담보조회 CODE", notes="담보를 CODE로 조회한다.")
    @GetMapping("/collateral/code/{code}")
    public ResponseEntity<CollateralDto> getCollateral(@PathVariable String code) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(collService.findByCode(code));
    }

    @ApiOperation(value = "전체담보조회", notes="모든 담보를 조회한다.")
    @GetMapping("/collaterals")
    public ResponseEntity<List<CollateralDto>> getCollaterals() throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(collService.findAll());
    }
}
