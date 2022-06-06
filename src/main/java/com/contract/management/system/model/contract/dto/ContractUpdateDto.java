package com.contract.management.system.model.contract.dto;

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
    @NotNull(message = "변경하실 계약ID값을 설정하시기 바랍니다.")
    @Positive(message = "변경하실 계약ID값을 설정하시기 바랍니다.")
    private long contractId;
    @NotNull(message = "변경 계약기간을 설정하시기 바랍니다.")
    @Positive(message = "계약기간은 0이상 설정하시기 바랍니다.")
    private int period;
    private Set<Long> addCollateralIds;
    private Set<Long> deleteContractCollateralIds;
    @NotNull(message = "계약상태CODE를 설정하시기 바랍니다.")
    private String statusCode;
}
