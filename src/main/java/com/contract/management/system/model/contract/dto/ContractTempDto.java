package com.contract.management.system.model.contract.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractTempDto
{
    @ApiModelProperty(value = "보험시작일", example = "20220607")
    private String startDate;

    @ApiModelProperty(value = "보험종료일", example = "20220907")
    private String endDate;

    @ApiModelProperty(value = "총 보험료", example = "20000")
    private double totalMoney;
}
