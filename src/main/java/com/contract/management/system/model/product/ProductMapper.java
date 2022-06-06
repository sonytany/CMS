package com.contract.management.system.model.product;

import com.contract.management.system.model.collateral.entity.CollateralEntity;
import com.contract.management.system.model.product.dto.ProductAddDto;
import com.contract.management.system.model.product.dto.ProductCollateralDto;
import com.contract.management.system.model.product.dto.ProductDto;
import com.contract.management.system.model.product.entiry.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper
{
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "collaterals", ignore = true)
    @Mapping(target = "id", ignore = true)
    ProductEntity toEntity(ProductAddDto productDto);

    ProductEntity toUpdateEntity(ProductDto productDto);

    default ProductDto toDto(ProductEntity productEntity)
    {
        ProductDto.ProductDtoBuilder dtoBuilder = ProductDto.builder();

        if(productEntity != null)
        {
            dtoBuilder.id(productEntity.getId())
                    .minPeriod(productEntity.getMinPeriod())
                    .maxPeriod(productEntity.getMaxPeriod())
                    .code(productEntity.getCode())
                    .name(productEntity.getName());

            List<CollateralEntity> collateralEntities = productEntity.getCollaterals();

            if(collateralEntities != null && !collateralEntities.isEmpty())
                dtoBuilder.collaterals(toProductCollateralDtos(collateralEntities));
        }

        return dtoBuilder.build();
    }

    List<ProductDto> toDtos(List<ProductEntity> productEntities);

    default List<ProductCollateralDto> toProductCollateralDtos(List<CollateralEntity> collateralEntites)
    {
        ProductCollateralDto.ProductCollateralDtoBuilder dtoBuilder = ProductCollateralDto.builder();
        List<ProductCollateralDto> dtos = new ArrayList<>();

        if(collateralEntites != null && !collateralEntites.isEmpty())
        {
            for(CollateralEntity entity : collateralEntites)
            {
                dtoBuilder.id(entity.getId())
                        .code(entity.getCode())
                        .name(entity.getName())
                        .insurableMoney(entity.getInsurableMoney())
                        .standardMoney(entity.getStandardMoney());

                dtos.add(dtoBuilder.build());
            }
        }

        return dtos;
    }
}
