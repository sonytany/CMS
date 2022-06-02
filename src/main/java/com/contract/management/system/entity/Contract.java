package com.contract.management.system.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Contract
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String code;
    @Column(nullable = false)
    private int startMonth;
    private int endMonth;
    private int totalMoney;
    private String status;
    @OneToOne(mappedBy = "contract")
    private ContractProduct contractProduct;
    @OneToMany(mappedBy = "contract")
    private List<ContractCollateral> contractCollaterals;

    public Contract(){}

    public Contract(int id, String code, int startMonth, int endMonth, int totalMoney, String status, ContractProduct contractProduct, List<ContractCollateral> contractCollaterals)
    {
        this.id = id;
        this.code = code;
        this.startMonth = startMonth;
        this.endMonth = endMonth;
        this.totalMoney = totalMoney;
        this.status = status;
        this.contractProduct = contractProduct;
        this.contractCollaterals = contractCollaterals;
    }

    public Contract(String code, int startMonth, int endMonth, int totalMoney, String status, ContractProduct contractProduct, List<ContractCollateral> contractCollaterals)
    {
        this.code = code;
        this.startMonth = startMonth;
        this.endMonth = endMonth;
        this.totalMoney = totalMoney;
        this.status = status;
        this.contractProduct = contractProduct;
        this.contractCollaterals = contractCollaterals;
    }
}
