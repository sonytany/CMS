package com.contract.management.system.model;

import com.contract.management.system.model.dto.ProductDto;
import com.contract.management.system.model.entity.CollateralEntity;
import com.contract.management.system.model.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper
{
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "collaterals", ignore = true)
    @Mapping(target = "id", ignore = true)
    ProductEntity toEntity(ProductDto productDto);

    default ProductDto toDto(ProductEntity productEntity)
    {
        ProductDto.ProductDtoBuilder dtoBuilder = ProductDto.builder();

        if(productEntity != null)
        {
            dtoBuilder.productId(productEntity.getId())
                    .code(productEntity.getCode())
                    .name(productEntity.getName());

            List<CollateralEntity> collateralEntities = productEntity.getCollaterals();

            if(collateralEntities != null && !collateralEntities.isEmpty())
                dtoBuilder.collateralDtos(CollateralMapper.INSTANCE.toDtos(collateralEntities));
        }

        return dtoBuilder.build();
    }

    List<ProductDto> toDtos(List<ProductEntity> productEntities);
}
