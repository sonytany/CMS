package com.contract.management.system.service.collateral;

import com.contract.management.system.exception.BaseException;
import com.contract.management.system.model.collateral.dto.CollateralAddDto;
import com.contract.management.system.model.collateral.dto.CollateralDto;

import java.util.List;

public interface CollateralService
{
    CollateralDto addCollateral(CollateralAddDto dto) throws BaseException;
    CollateralDto updateCollateral(CollateralDto dto) throws BaseException;
    void deleteById(long id) throws BaseException;
    CollateralDto findById(long id) throws BaseException;
    CollateralDto findByCode(String code) throws BaseException;
    List<CollateralDto> findAll() throws BaseException;
}
