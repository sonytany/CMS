package com.contract.management.system.dao.contract;

import com.contract.management.system.model.contract.entity.ContractEntity;
import com.contract.management.system.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConstractDaoImpl implements ConstractDao
{
    private final ContractRepository contractRepository;

    @Override
    public ContractEntity save(ContractEntity entity)
    {
        return contractRepository.save(entity);
    }

    @Override
    public void deleteById(int id)
    {
        contractRepository.deleteById(id);
    }

    @Override
    public ContractEntity findById(int id)
    {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public List<ContractEntity> findAll()
    {
        return contractRepository.findAll();
    }
}
