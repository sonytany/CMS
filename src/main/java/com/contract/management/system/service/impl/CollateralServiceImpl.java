package com.contract.management.system.service.impl;

import com.contract.management.system.dao.CollateralDao;
import com.contract.management.system.dto.CollateralDto;
import com.contract.management.system.repository.CollateralRepository;
import com.contract.management.system.repository.ProductRepository;
import com.contract.management.system.service.CollateralService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CollateralServiceImpl implements CollateralService
{
    private final CollateralDao collateralDao;
//    @Override
//    public CollateralDTO add(CollateralDTO dto)
//    {
//        Collateral entity = dtoToEntityByADD(dto);
//        entity.setProduct(prodRepo.findById(dto.getProductId()).orElse(null));
//        return entityToDto(collRepo.save(entity));
//    }
//
//    @Override
//    public void delete(int id)
//    {
//        collRepo.deleteById(id);
//    }

//    @Override
//    public CollateralDto add(CollateralDto dto)
//    {
//        return null;
//    }

    @Override
    public CollateralDto findById(int id)
    {
        return collateralDao.findById(id).toDto();
    }

//    @Override
//    public List<CollateralDTO> getByName(String name)
//    {
//        return entitysToDtos(collRepo.findByNameLike("%"+name+"%"));
//    }

//    @Override
//    public List<CollateralDTO> getAll()
//    {
//        return entitysToDtos((List<Collateral>) collRepo.findAll());
//    }
}
