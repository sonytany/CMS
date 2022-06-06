package com.contract.management.system.model.contract.dto;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "계약한 담보코드", example = "INJURY_PAY")
    private String code;

    @ApiModelProperty(value = "계약한 담보명", example = "상해치료비")
    private String name;

    @ApiModelProperty(value = "계약한 담보가입금액", example = "1000000")
    private int insurableMoney;

    @ApiModelProperty(value = "계약한 담보기준금액", example = "100")
    private int standardMoney;
}
