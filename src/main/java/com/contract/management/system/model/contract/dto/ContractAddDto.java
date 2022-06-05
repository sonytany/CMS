package com.contract.management.system.model.contract.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractAddDto
{
    private int period;
    private int productId;
    private long[] collateralIds;
}
