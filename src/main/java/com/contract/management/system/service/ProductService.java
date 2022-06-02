package com.contract.management.system.service;

import com.contract.management.system.dto.CollateralDTO;
import com.contract.management.system.dto.ProductDTO;
import com.contract.management.system.entity.Collateral;
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
                .code(dto.getCode())
                .name(dto.getName())
                .build();

        return entity;
    }

    default Product dtoToEntity(ProductDTO dto)
    {
        Product entity = Product.builder()
                .id(dto.getId())
                .code(dto.getCode())
                .name(dto.getName())
                .build();

        return entity;
    }

    default ProductDTO entityToDto(Product entity)
    {
        List<CollateralDTO> collDtos = new ArrayList<>();
        List<Collateral> collEntitys = entity.getCollaterals();

        if(collEntitys != null && !collEntitys.isEmpty())
        {
            collEntitys.forEach((collEntity) -> {
                CollateralDTO collDto = CollateralDTO.builder()
                        .id(collEntity.getId())
                        .code(collEntity.getCode())
                        .name(collEntity.getName())
                        .productId(collEntity.getProduct().getId())
                        .insurableMoney(collEntity.getInsurableMoney())
                        .standardMoney(collEntity.getStandardMoney())
                        .build();
                collDtos.add(collDto);
            });
        }

        ProductDTO dto = ProductDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .collaterals(collDtos)
                .build();

        return dto;
    }
}
