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
public class ContractDto implements Serializable
{
    @ApiModelProperty(value = "계약정보ID", example = "2")
    private long id;

    @ApiModelProperty(value = "계약번호", example = "20220607190647351")
    private String code;

    @ApiModelProperty(value = "보험시작일", example = "20220607")
    private String startDate;

    @ApiModelProperty(value = "보험종료일", example = "20220907")
    private String endDate;

    @ApiModelProperty(value = "총 보험료", example = "2000")
    private double totalMoney;

    @ApiModelProperty(value = "계약상태 코드", example = "NORMAL")
    private String statusCode;

    @ApiModelProperty(value = "계약상태", example = "정상계약")
    private String statusValue;

    @ApiModelProperty(value = "선택한 상품", example = "선택한 상품객체")
    private ContractProductDto product;
}
