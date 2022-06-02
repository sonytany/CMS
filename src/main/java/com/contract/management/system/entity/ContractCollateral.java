package com.contract.management.system.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder
@Data
@Entity
public class ContractCollateral
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String code;
    private String name;
    private int insurableMoney;
    private int standardMoney;
    @ManyToOne
    private ContractProduct contractProduct;
    @ManyToOne
    private Contract contract;

    public ContractCollateral() {}

    public ContractCollateral(int id, String code, String name, int insurableMoney, int standardMoney, ContractProduct contractProduct, Contract contract)
    {
        this.id = id;
        this.code = code;
        this.name = name;
        this.insurableMoney = insurableMoney;
        this.standardMoney = standardMoney;
        this.contractProduct = contractProduct;
        this.contract = contract;
    }

    public ContractCollateral(String code, String name, int insurableMoney, int standardMoney, ContractProduct contractProduct, Contract contract)
    {
        this.code = code;
        this.name = name;
        this.insurableMoney = insurableMoney;
        this.standardMoney = standardMoney;
        this.contractProduct = contractProduct;
        this.contract = contract;
    }
}
