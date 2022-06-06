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
    private long id;
    private String code;
    private String startDate;
    private String endDate;
    private double totalMoney;
    private String statusCode;
    private String statusValue;
    private ContractProductDto product;
}
