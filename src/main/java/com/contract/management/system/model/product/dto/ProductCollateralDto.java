package com.contract.management.system.model.product.dto;

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
public class ProductCollateralDto implements Serializable
{
    @ApiModelProperty(value = "담보ID", example = "1")
    private long id;

    @ApiModelProperty(value = "담보코드", example = "PCODE1")
    private String code;

    @ApiModelProperty(value = "담보명", example = "상품1")
    private String name;

    @ApiModelProperty(value = "기준금액", example = "10000")
    private int insurableMoney;

    @ApiModelProperty(value = "가입금액", example = "100")
    private int standardMoney;
}
