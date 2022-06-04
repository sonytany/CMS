package com.contract.management.system.service.constract;

import com.contract.management.system.model.contract.ContractMapper;
import com.contract.management.system.model.contract.dto.ContractDto;
import com.contract.management.system.dao.contract.ConstractDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService
{
    private final ConstractDao constractDao;

    @Override
    public ContractDto save(ContractDto dto)
    {
        return null;
    }

    @Override
    public void delete(int id)
    {
        constractDao.deleteById(id);
    }

    @Override
    public ContractDto findById(int id)
    {
        return ContractMapper.INSTANCE.toDto(constractDao.findById(id));
    }

    @Override
    public List<ContractDto> findByCode(String Code)
    {
        return null;
    }

    @Override
    public List<ContractDto> findAll()
    {
        return null;
    }
}
