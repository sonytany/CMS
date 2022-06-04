package com.contract.management.system.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Entity
@Table(name = "collateral")
@NoArgsConstructor
@AllArgsConstructor
public class CollateralEntity
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
    private ProductEntity product;
}
