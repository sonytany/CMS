package com.contract.management.system.model.collateral;

import com.contract.management.system.model.collateral.dto.CollateralDto;
import com.contract.management.system.model.collateral.entity.CollateralEntity;
import com.contract.management.system.model.product.entiry.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CollateralMapper
{
    CollateralMapper INSTANCE = Mappers.getMapper(CollateralMapper.class);

    @Mapping(target = "product", ignore = true)
    @Mapping(target = "id", ignore = true)
    CollateralEntity toEntity(CollateralDto collateralDto);

    default CollateralDto toDto(CollateralEntity collateralEntity)
    {
       CollateralDto.CollateralDtoBuilder dtoBuilder = CollateralDto.builder();

        if(collateralEntity != null)
        {
            dtoBuilder.collateralId(collateralEntity.getId())
                    .code(collateralEntity.getCode())
                    .name(collateralEntity.getName())
                    .insurableMoney(collateralEntity.getInsurableMoney())
                    .standardMoney(collateralEntity.getStandardMoney());

            ProductEntity product = collateralEntity.getProduct();

            dtoBuilder.productId(product.getId()).productCode(product.getCode()).productName(product.getName());
        }

        return dtoBuilder.build();
    }

    List<CollateralDto> toDtos(List<CollateralEntity> collateralEntities);
}
