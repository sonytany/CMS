package com.contract.management.system.dao.contract.impl;

import com.contract.management.system.dao.contract.ContractDao;
import com.contract.management.system.model.contract.entity.ContractEntity;
import com.contract.management.system.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractDaoImpl implements ContractDao
{
    private final ContractRepository contractRepository;

    @Override
    public ContractEntity save(ContractEntity entity)
    {
        return contractRepository.save(entity);
    }

    @Override
    public ContractEntity findById(long id)
    {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public ContractEntity findByCode(String code)
    {
        return contractRepository.findByCode(code);
    }

    @Override
    public List<ContractEntity> findByEndDateGreaterThan(String expireDate)
    {
        return contractRepository.findByEndDateGreaterThan(expireDate);
    }
}
