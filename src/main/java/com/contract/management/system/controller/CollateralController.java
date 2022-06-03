package com.contract.management.system.controller;

import com.contract.management.system.dto.CollateralDto;
import com.contract.management.system.service.CollateralService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
public class CollateralController
{
    private final CollateralService collService;

//    @PutMapping("/collateral")
//    public CollateralDto putCollateral(CollateralDto dto)
//    {
//        return collService.add(dto);
//    }

//    @DeleteMapping("/collateral")
//    public void deleteCollateral(int id)
//    {
//        collService.delete(id);
//    }

    @GetMapping("/collateral")
    public CollateralDto getCollateral(int id)
    {
        return collService.findById(id);
    }

//    @GetMapping("/collaterals")
//    public List<CollateralDto> getCollaterals()
//    {
//        return collService.getAll();
//    }
}
