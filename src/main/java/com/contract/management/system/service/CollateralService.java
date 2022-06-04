package com.contract.management.system.service;

import com.contract.management.system.model.dto.CollateralDto;
import com.contract.management.system.model.entity.CollateralEntity;

import java.util.List;

public interface CollateralService
{
    CollateralEntity save(CollateralDto dto);
    void deleteById(int id);
    CollateralEntity findById(int id);
    List<CollateralEntity> findAll();
}
