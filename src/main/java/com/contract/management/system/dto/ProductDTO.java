package com.contract.management.system.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class ProductDTO
{
    private int id;
    private String code;
    private String name;
    private List<CollateralDTO> collaterals;

    public ProductDTO(){}

    public ProductDTO(int id, String code, String name, List<CollateralDTO> collaterals)
    {
        this.id = id;
        this.code = code;
        this.name = name;
        this.collaterals = collaterals;
    }

    public ProductDTO(String code, String name)
    {
        this.code = code;
        this.name = name;
    }
}
