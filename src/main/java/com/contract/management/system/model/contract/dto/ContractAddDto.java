package com.contract.management.system.model.contract.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractAddDto
{
    @NotNull
    private long productId;
    @NotNull
    private int period;
    @NotNull
    @Size(min = 1)
    private long[] collateralIds;

}
