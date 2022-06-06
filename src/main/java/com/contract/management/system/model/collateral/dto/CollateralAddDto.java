package com.contract.management.system.model.collateral.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CollateralAddDto
{
    @ApiModelProperty(value = "담보코드", example = "DCODE1")
    @NotNull
    private String code;

    @ApiModelProperty(value = "담보명", example = "담보1")
    @NotNull
    private String name;

    @ApiModelProperty(value = "가입금액", example = "10000")
    @Positive
    private int insurableMoney;

    @ApiModelProperty(value = "기준금액", example = "100")
    @Positive
    private int standardMoney;

    @ApiModelProperty(value = "상품ID (부모ID)", example = "1")
    private long productId;
}
