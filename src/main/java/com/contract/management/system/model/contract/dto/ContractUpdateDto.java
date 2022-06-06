package com.contract.management.system.model.contract.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractUpdateDto
{
    @ApiModelProperty(value = "계약정보ID", example = "2")
    @NotNull(message = "변경하실 계약정보ID를 설정하시기 바랍니다.")
    @Positive(message = "변경하실 계약정보ID를 설정하시기 바랍니다.")
    private long contractId;

    @ApiModelProperty(value = "계약기간", example = "3")
    @NotNull(message = "변경 계약기간을 설정하시기 바랍니다.")
    @Positive(message = "계약기간은 0이상 설정하시기 바랍니다.")
    private int period;

    @ApiModelProperty(value = "추가할 담보목록 ID값들", example = "담보ID set")
    private Set<Long> addCollateralIds;

    @ApiModelProperty(value = "삭제할 기존담보목록 ID값들", example = "2")
    private Set<Long> deleteContractCollateralIds;

    @ApiModelProperty(value = "계약상태코드", example = "NORMAL")
    @NotNull(message = "계약상태CODE를 설정하시기 바랍니다.")
    private String statusCode;
}
