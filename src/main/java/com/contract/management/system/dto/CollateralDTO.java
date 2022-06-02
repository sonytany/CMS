package com.contract.management.system.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class CollateralDTO
{
    private int id;
    private int productId;
    private String code;
    private String name;
    private int insurableMoney;
    private int standardMoney;

    public CollateralDTO() {}

    public CollateralDTO(int id, int productId, String code, String name, int insurableMoney, int standardMoney)
    {
        this.id = id;
        this.productId = productId;
        this.code = code;
        this.name = name;
        this.insurableMoney = insurableMoney;
        this.standardMoney = standardMoney;
    }

    public CollateralDTO(int productId, String code, String name, int insurableMoney, int standardMoney)
    {
        this.productId = productId;
        this.code = code;
        this.name = name;
        this.insurableMoney = insurableMoney;
        this.standardMoney = standardMoney;
    }
}
