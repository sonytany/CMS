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
@Table(name = "contract")
public class ContractEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true, length = 17)
    private String code;
    @Column(nullable = false)
    private int period;
    private int startMonth;
    private int endMonth;
    private double totalMoney;
    private String status;
    @OneToOne(mappedBy = "contract")
    private ContractProductEntity contractProduct;
}
