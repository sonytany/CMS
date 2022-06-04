package com.contract.management.system.dao.contract;

import com.contract.management.system.model.contract.entity.ContractEntity;
import com.contract.management.system.model.contract.entity.ContractProductEntity;
import com.contract.management.system.repository.ContractProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractProductDaoImpl implements ContractProductDao
{
    private final ContractProductRepository contractProductRepository;

    @Override
    public ContractProductEntity save(ContractProductEntity entity)
    {
        return contractProductRepository.save(entity);
    }

    @Override
    public void deleteById(int id)
    {
        contractProductRepository.deleteById(id);
    }

    @Override
    public ContractProductEntity findById(int id)
    {
        return contractProductRepository.findById(id).orElse(null);
    }

    @Override
    public List<ContractProductEntity> findAll()
    {
        return contractProductRepository.findAll();
    }
}
