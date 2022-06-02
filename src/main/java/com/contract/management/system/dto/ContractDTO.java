package com.contract.management.system.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

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
    private ProductDTO product;
}
