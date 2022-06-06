package com.contract.management.system.model.contract.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "contract")
@Table(name = "contract_product")
public class ContractProductEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String code;
    private String name;
    @Min(value = 1)
    private int period;
    @OneToOne
    private ContractEntity contract;
    @OneToMany(mappedBy = "contractProduct")
    private List<ContractCollateralEntity> contractCollaterals;
}
