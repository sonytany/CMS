package com.contract.management.system.model.product.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductAddDto implements Serializable
{
    @ApiModelProperty(value = "상품코드", example = "PCODE1")
    private String code;

    @ApiModelProperty(value = "상품명", example = "상품1")
    private String name;

    @ApiModelProperty(value = "최소가입", example = "1")
    @Min(value = 1)
    @Max(value = 12)
    private int minPeriod;

    @ApiModelProperty(value = "최대가입", example = "1")
    @Min(value = 1)
    @Max(value = 12)
    private int maxPeriod;
}
