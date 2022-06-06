package com.contract.management.system.model.contract.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Set;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractAddDto
{
    @ApiModelProperty(value = "상품ID", example = "1")
    @NotNull(message = "상품ID값을 설정하시기 바랍니다.")
    private long productId;
    @ApiModelProperty(value = "계약기간", example = "3")
    @NotNull(message = "계약기간을 설정하시기 바랍니다.")
    @Positive(message = "계약기가은 0이상 설정하시기 바랍니다.")
    private int period;
    @ApiModelProperty(value = "담보 ID값들", example = "담보ID set")
    @NotNull(message = "담보ID값을 설정하시기 바랍니다.")
    @Size(min = 1, message = "담보는 최소한 1개를 설정하셔야 합니다.")
    private Set<Long> collateralIds;

}
