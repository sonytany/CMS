package com.contract.management.system.model.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductAddDto implements Serializable
{
    private long productId;
    private String code;
    private String name;
    @Min(value = 1)
    @Max(value = 12)
    private int minPeriod;
    @Min(value = 1)
    @Max(value = 12)
    private int maxPeriod;
    private List<ProductCollateralDto> collaterals;
}
