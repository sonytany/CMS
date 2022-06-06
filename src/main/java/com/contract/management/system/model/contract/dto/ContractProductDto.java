package com.contract.management.system.model.contract.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractProductDto implements Serializable
{
    @ApiModelProperty(value = "계약한 상품코드", example = "TRAVELER")
    private String code;

    @ApiModelProperty(value = "계약한 상품명", example = "여행자 보험")
    private String name;

    @ApiModelProperty(value = "계약기간", example = "3")
    private int period;

    @ApiModelProperty(value = "담보 ID값들", example = "담보ID set")
    private List<ContractCollateralDto> collaterals;
}
