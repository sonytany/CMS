package com.contract.management.system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable
{
    private int productId;
    private String code;
    private String name;
    private List<CollateralDto> collateralDtos;
}
