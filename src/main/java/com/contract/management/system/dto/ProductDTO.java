package com.contract.management.system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable
{
    private int id;
    private String code;
    private String name;
    private List<CollateralDto> collaterals;
}
