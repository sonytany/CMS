package com.contract.management.system.controller;

import com.contract.management.system.dto.CollateralDTO;
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

    @PutMapping("/collateral")
    public CollateralDTO putCollateral(CollateralDTO dto)
    {
        return collService.add(dto);
    }

    @DeleteMapping("/collateral")
    public void deleteCollateral(int id)
    {
        collService.delete(id);
    }

    @GetMapping("/collateral")
    public CollateralDTO getCollateral(int id)
    {
        return collService.getById(id);
    }

    @GetMapping("/collateral/name")
    public List<CollateralDTO> getCollateral(String name)
    {
        return collService.getByName(name);
    }

    @GetMapping("/collaterals")
    public List<CollateralDTO> getCollaterals()
    {
        return collService.getAll();
    }
}
