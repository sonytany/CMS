package com.contract.management.system.model.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCollateralDto implements Serializable
{
    private int collateralId;
    private String code;
    private String name;
    private int insurableMoney;
    private int standardMoney;
}
