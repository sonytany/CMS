package com.contract.management.system.model.collateral.dto;

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
public class CollateralDto implements Serializable
{
    @ApiModelProperty(example = "1", value = "담보ID")
    private long id;

    @ApiModelProperty(example = "INJURY_PAY", value = "담보코드")
    private String code;

    @ApiModelProperty(example = "상해치료비", value = "담보명")
    private String name;

    @ApiModelProperty(example = "1000000", value = "담보 가입금액")
    private int insurableMoney;

    @ApiModelProperty(example = "100", value = "담보 기준금액")
    private int standardMoney;

    @ApiModelProperty(example = "1", value = "상품ID (부모ID)")
    private long productId;

    @ApiModelProperty(example = "TRAVELER", value = "상품코드")
    private String productCode;

    @ApiModelProperty(example = "여행자 보험", value = "상품명")
    private String productName;
}
