package com.contract.management.system.dao.contract.impl;

import com.contract.management.system.dao.contract.ContractCollateralDao;
import com.contract.management.system.model.contract.entity.ContractCollateralEntity;
import com.contract.management.system.repository.ContractCollateralRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Set;

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
    @Positive(message = "id값은 0일 수 없습니다.")
    public void deleteById(long id)
    {
        contractCollateralRepository.deleteById(id);
    }

    @Override
    public ContractCollateralEntity findById(long id)
    {
        return contractCollateralRepository.findById(id).orElse(null);
    }

    @Override
    public List<ContractCollateralEntity> findByIdIn(Set<Long> ids)
    {
        return contractCollateralRepository.findByIdIn(ids);
    }

    @Override
    public List<ContractCollateralEntity> findByContractProductId(long contractProductId)
    {
        return contractCollateralRepository.findByContractProductId(contractProductId);
    }
}
