package com.contract.management.system.model.contract.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractUpdateDto
{
    @NotNull
    private long contractId;
    @NotNull
    private int period;
    @NotNull
    @Size(min = 1)
    private long[] collateralIds;
    @NotNull
    private String statusCode;
}
