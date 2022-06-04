package com.contract.management.system.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ContractDTO
{
    private int id;
    private String code;
    private int startMonth;
    private int endMonth;
    private int totalMoney;
    private String status;
    private ProductDto product;
}
