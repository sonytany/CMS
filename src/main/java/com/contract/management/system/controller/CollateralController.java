package com.contract.management.system.controller;

import com.contract.management.system.exception.BaseException;
import com.contract.management.system.exception.Constants;
import com.contract.management.system.model.CollateralMapper;
import com.contract.management.system.model.dto.CollateralDto;
import com.contract.management.system.model.entity.CollateralEntity;
import com.contract.management.system.service.CollateralService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequiredArgsConstructor
public class CollateralController
{
    private final CollateralService collService;

    @PutMapping("/collateral")
    public CollateralDto putCollateral(@RequestBody CollateralDto dto) throws BaseException
    {
        return CollateralMapper.INSTANCE.toDto(collService.save(dto));
    }

    @PostMapping("/collateral")
    public CollateralDto postCollateral(@RequestBody CollateralDto dto) throws BaseException
    {
        return CollateralMapper.INSTANCE.toDto(collService.save(dto));
    }

    @DeleteMapping("/collateral")
    public void deleteCollateral(int id) throws BaseException
    {
        collService.deleteById(id);
    }

    @GetMapping("/collateral")
    public CollateralDto getCollateral(int id) throws BaseException
    {
        return CollateralMapper.INSTANCE.toDto(collService.findById(id));
    }

    @GetMapping("/collaterals")
    public List<CollateralDto> getCollaterals() throws BaseException
    {
        return CollateralMapper.INSTANCE.toDtos(collService.findAll());
    }

    @GetMapping("/exception")
    public void getException() throws BaseException
    {
        throw new BaseException(Constants.ExceptionClass.COLLATERAL, HttpStatus.BAD_REQUEST, "오류 발생확인");
    }
}
