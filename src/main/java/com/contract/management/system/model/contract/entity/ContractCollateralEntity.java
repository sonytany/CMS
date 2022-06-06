package com.contract.management.system.model.contract.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "contractProduct")
@Table(name = "contract_collateral")
public class ContractCollateralEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String code;
    private String name;
    private int insurableMoney;
    private int standardMoney;

    @ManyToOne
    private ContractProductEntity contractProduct;
}
