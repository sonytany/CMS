package com.contract.management.system.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder
@Data
@Entity
public class Collateral
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
    private Product product;

    public Collateral() {}

    public Collateral(int id, String code, String name, int insurableMoney, int standardMoney, Product product)
    {
        this.id = id;
        this.code = code;
        this.name = name;
        this.insurableMoney = insurableMoney;
        this.standardMoney = standardMoney;
        this.product = product;
    }

    public Collateral(String code, String name, int insurableMoney, int standardMoney, Product product)
    {
        this.code = code;
        this.name = name;
        this.insurableMoney = insurableMoney;
        this.standardMoney = standardMoney;
        this.product = product;
    }
}
