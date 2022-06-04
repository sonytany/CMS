package com.contract.management.system.model.dto;

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
    private int collateralId;
    private String code;
    private String name;
    private int insurableMoney;
    private int standardMoney;
    private int productId;
    private String productCode;
    private String productName;
}
