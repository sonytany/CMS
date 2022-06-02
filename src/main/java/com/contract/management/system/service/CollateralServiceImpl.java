package com.contract.management.system.service;

import com.contract.management.system.dto.CollateralDTO;
import com.contract.management.system.entity.Collateral;
import com.contract.management.system.repository.CollateralRepository;
import com.contract.management.system.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class CollateralServiceImpl implements CollateralService
{
    private final CollateralRepository collRepo;
    private final ProductRepository prodRepo;

    @Override
    public CollateralDTO add(CollateralDTO dto)
    {
        Collateral entity = dtoToEntityByADD(dto);
        entity.setProduct(prodRepo.findById(dto.getProductId()).orElse(null));
        return entityToDto(collRepo.save(entity));
    }

    @Override
    public void delete(int id)
    {
        collRepo.deleteById(id);
    }

    @Override
    public CollateralDTO getById(int id)
    {
        return entityToDto(collRepo.findById(id).orElse(null));
    }

    @Override
    public List<CollateralDTO> getByName(String name)
    {
        return entitysToDtos(collRepo.findByNameLike("%"+name+"%"));
    }

    @Override
    public List<CollateralDTO> getAll()
    {
        return entitysToDtos((List<Collateral>) collRepo.findAll());
    }
}
