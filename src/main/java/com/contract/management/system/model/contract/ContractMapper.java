package com.contract.management.system.model.contract;

import com.contract.management.system.constans.ContractStatusType;
import com.contract.management.system.model.collateral.entity.CollateralEntity;
import com.contract.management.system.model.contract.dto.ContractAddDto;
import com.contract.management.system.model.contract.dto.ContractCollateralDto;
import com.contract.management.system.model.contract.dto.ContractDto;
import com.contract.management.system.model.contract.dto.ContractProductDto;
import com.contract.management.system.model.contract.entity.ContractCollateralEntity;
import com.contract.management.system.model.contract.entity.ContractEntity;
import com.contract.management.system.model.contract.entity.ContractProductEntity;
import com.contract.management.system.model.product.entiry.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContractMapper
{
    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    List<ContractDto> toDtos(List<ContractEntity> contractEntities);

    default List<ContractCollateralEntity> toAddCollateralEntities(List<CollateralEntity> collateralEntities)
    {
        ContractCollateralEntity.ContractCollateralEntityBuilder entityBuilder = ContractCollateralEntity.builder();
        List<ContractCollateralEntity> entities = new ArrayList<>();

        for(CollateralEntity collateralEntity : collateralEntities)
        {
            entityBuilder.code(collateralEntity.getCode())
                    .name(collateralEntity.getName())
                    .insurableMoney(collateralEntity.getInsurableMoney())
                    .standardMoney(collateralEntity.getStandardMoney());

            entities.add(entityBuilder.build());
        }

        return entities;
    }

    default ContractProductEntity toAddProductEntity(ProductEntity productEntity)
    {
        ContractProductEntity.ContractProductEntityBuilder entityBuilder = ContractProductEntity.builder();

        if(productEntity != null)
        {
            entityBuilder.code(productEntity.getCode())
                    .name(productEntity.getName());
        }

        return entityBuilder.build();
    }

    default ContractEntity toAddEntity(ContractAddDto contractAddDto)
    {
        ContractEntity.ContractEntityBuilder entityBuilder = ContractEntity.builder();

        if(contractAddDto != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmssSSS");

            entityBuilder.code(sdf.format(new Date(System.currentTimeMillis())))
                    .period(contractAddDto.getPeriod())
                    .status(ContractStatusType.NORMAL.name());
        }

        return entityBuilder.build();
    }

    default ContractDto toDto(ContractEntity contractEntity)
    {
        ContractDto.ContractDtoBuilder dtoBuilder = ContractDto.builder();

        if(contractEntity != null)
        {
            dtoBuilder.id(contractEntity.getId())
                    .code(contractEntity.getCode())
                    .period(contractEntity.getPeriod())
                    .startMonth(contractEntity.getStartMonth())
                    .endMonth(contractEntity.getEndMonth())
                    .totalMoney(contractEntity.getTotalMoney())
                    .status(ContractStatusType.valueOf(contractEntity.getStatus()).getValue())
                    .product(toContractProductDto(contractEntity.getContractProduct()));
        }

        return dtoBuilder.build();
    }

    default ContractProductDto toContractProductDto(ContractProductEntity contractProduct)
    {
        ContractProductDto.ContractProductDtoBuilder dtoBuilder = ContractProductDto.builder();
        dtoBuilder.code(contractProduct.getCode())
                .name(contractProduct.getName())
                .collaterals(toContractCollateralDtos(contractProduct.getContractCollaterals()));

        return dtoBuilder.build();
    }

    default List<ContractCollateralDto> toContractCollateralDtos(List<ContractCollateralEntity> contractCollateralEntities)
    {
        ContractCollateralDto.ContractCollateralDtoBuilder dtoBuilder = ContractCollateralDto.builder();
        List<ContractCollateralDto> dtos = new ArrayList<>();

        if(contractCollateralEntities != null && !contractCollateralEntities.isEmpty())
        {
            for(ContractCollateralEntity entity : contractCollateralEntities)
            {
                dtoBuilder.code(entity.getCode())
                        .name(entity.getName())
                        .insurableMoney(entity.getInsurableMoney())
                        .standardMoney(entity.getStandardMoney());

                dtos.add(dtoBuilder.build());
            }
        }

        return dtos;
    }
}
