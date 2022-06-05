package com.contract.management.system.model.collateral.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CollateralDto implements Serializable
{
    private long collateralId;
    private String code;
    private String name;
    private int insurableMoney;
    private int standardMoney;
    private long productId;
    private String productCode;
    private String productName;
}
