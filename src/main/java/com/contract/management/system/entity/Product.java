package com.contract.management.system.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String code;
    private String name;
    @OneToMany(mappedBy = "product")
    private List<Collateral> collaterals;

    public Product(){}

    public Product(int id, String code, String name, List<Collateral> collaterals)
    {
        this.id = id;
        this.code = code;
        this.name = name;
        this.collaterals = collaterals;
    }

    public Product(String code, String name)
    {
        this.code = code;
        this.name = name;
    }
}
