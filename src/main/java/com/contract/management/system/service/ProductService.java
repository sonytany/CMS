package com.contract.management.system.service;

import com.contract.management.system.dto.CollateralDto;
import com.contract.management.system.dto.ProductDTO;
import com.contract.management.system.entity.CollateralEntity;
import com.contract.management.system.entity.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService
{
    ProductDTO add(ProductDTO dto);
    ProductDTO update(ProductDTO dto);
    void delete(int id);
    ProductDTO getById(int id);
    List<ProductDTO> getByName(String name);
    List<ProductDTO> getAll();


    default Product dtoToEntityByADD(ProductDTO dto)
    {
        Product entity = Product.builder()
                .build();

        return entity;
    }

    default Product dtoToEntity(ProductDTO dto)
    {
        Product entity = Product.builder()
                .build();

        return entity;
    }

    default ProductDTO entityToDto(Product entity)
    {
        List<CollateralDto> collDtos = new ArrayList<>();
        List<CollateralEntity> collEntitys = entity.getCollaterals();

        if(collEntitys != null && !collEntitys.isEmpty())
        {
            collEntitys.forEach((collEntity) -> {
                CollateralDto collDto = CollateralDto.builder()
                        .code(collEntity.getCode())
                        .name(collEntity.getName())
                        .insurableMoney(collEntity.getInsurableMoney())
                        .standardMoney(collEntity.getStandardMoney())
                        .build();
                collDtos.add(collDto);
            });
        }

        ProductDTO dto = ProductDTO.builder()
                .code(entity.getCode())
                .name(entity.getName())
                .collaterals(collDtos)
                .build();

        return dto;
    }
}
