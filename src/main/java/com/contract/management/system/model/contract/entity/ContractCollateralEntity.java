package com.contract.management.system.model.contract.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contract_collateral")
public class ContractCollateralEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String code;
    private String name;
    private int insurableMoney;
    private int standardMoney;

    @ManyToOne
    private ContractProductEntity contractProduct;
}
