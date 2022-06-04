package com.contract.management.system.dao.contract;

import com.contract.management.system.model.contract.entity.ContractCollateralEntity;
import com.contract.management.system.repository.ContractCollateralRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractCollateralDaoImpl implements ContractCollateralDao
{
    private final ContractCollateralRepository contractCollateralRepository;

    @Override
    public ContractCollateralEntity save(ContractCollateralEntity entity)
    {
        return contractCollateralRepository.save(entity);
    }

    @Override
    public void deleteById(int id)
    {
        contractCollateralRepository.deleteById(id);
    }

    @Override
    public ContractCollateralEntity findById(int id)
    {
        return contractCollateralRepository.findById(id).orElse(null);
    }

    @Override
    public List<ContractCollateralEntity> findAll()
    {
        return contractCollateralRepository.findAll();
    }
}
