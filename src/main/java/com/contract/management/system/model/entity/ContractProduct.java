package com.contract.management.system.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@Entity
public class ContractProduct
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String code;
    private String name;
    @OneToOne
    private Contract contract;
    @OneToMany(mappedBy = "contractProduct")
    private List<ContractCollateral> contractCollaterals;

    public ContractProduct(){}

    public ContractProduct(int id, String code, String name, Contract contract, List<ContractCollateral> contractCollaterals)
    {
        this.id = id;
        this.code = code;
        this.name = name;
        this.contract = contract;
        this.contractCollaterals = contractCollaterals;
    }

    public ContractProduct(String code, String name, Contract contract, List<ContractCollateral> contractCollaterals)
    {
        this.code = code;
        this.name = name;
        this.contract = contract;
        this.contractCollaterals = contractCollaterals;

    }
}
