package com.contract.management.system.model.product.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable
{
    @ApiModelProperty(value = "상품ID", example = "1")
    @NotNull
    private long id;

    @ApiModelProperty(value = "상품코드", example = "TRAVELER")
    @NotNull
    private String code;

    @ApiModelProperty(value = "상품명", example = "여행자 보험")
    private String name;

    @ApiModelProperty(value = "최소가입", example = "1")
    @Min(value = 1)
    @Max(value = 12)
    private int minPeriod;

    @ApiModelProperty(value = "최대가입", example = "3")
    @Min(value = 1)
    @Max(value = 12)
    private int maxPeriod;

    @ApiModelProperty(value = "상품에 속한 담보들", example = "담보 리스트")
    private List<ProductCollateralDto> collaterals;
}
