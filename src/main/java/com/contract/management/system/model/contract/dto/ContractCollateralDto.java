package com.contract.management.system.model.contract.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractCollateralDto implements Serializable
{
    private String code;
    private String name;
    private int insurableMoney;
    private int standardMoney;
}
