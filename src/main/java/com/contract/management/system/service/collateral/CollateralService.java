package com.contract.management.system.service.collateral;

import com.contract.management.system.exception.BaseException;
import com.contract.management.system.model.collateral.dto.CollateralDto;

import java.util.List;

public interface CollateralService
{
    CollateralDto save(CollateralDto dto) throws BaseException;
    void deleteById(int id) throws BaseException;
    CollateralDto findById(int id) throws BaseException;
    List<CollateralDto> findAll() throws BaseException;
}
