package com.contract.management.system.service;

import com.contract.management.system.dto.ProductDTO;
import com.contract.management.system.entity.Product;
import com.contract.management.system.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository prodRepo;

    @Override
    public ProductDTO add(ProductDTO dto)
    {
        return entityToDto(prodRepo.save(dtoToEntityByADD(dto)));
    }

    @Override
    public ProductDTO update(ProductDTO dto)
    {
        return entityToDto(prodRepo.save(dtoToEntity(dto)));
    }

    @Override
    public void delete(int id)
    {
        prodRepo.deleteById(id);
    }

    @Override
    public ProductDTO getById(int id)
    {
        return entityToDto(prodRepo.findById(id).orElse(null));
    }

    @Override
    public List<ProductDTO> getByName(String name)
    {
        return entitysToDtos(prodRepo.findByNameLike("%"+name+"%"));
    }

    @Override
    public List<ProductDTO> getAll()
    {
        return entitysToDtos((List<Product>) prodRepo.findAll());
    }

    public List<ProductDTO> entitysToDtos(List<Product> prodEntitys)
    {
        List<ProductDTO> prodDtos = new ArrayList<>();
        prodEntitys.forEach((product) -> {
            prodDtos.add(entityToDto(product));
        });

        return prodDtos;
    }
}
