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
public class ContractDto implements Serializable
{
    private int id;
    private String code;
    private int period;
    private int startMonth;
    private int endMonth;
    private double totalMoney;
    private String status;
    private ContractProductDto product;
}
