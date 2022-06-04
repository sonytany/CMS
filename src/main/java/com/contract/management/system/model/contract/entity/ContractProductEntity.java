package com.contract.management.system.model.contract.entity;

import com.contract.management.system.model.product.entiry.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contract_product")
public class ContractProductEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String code;
    private String name;
    @OneToOne
    private ContractEntity contract;
    @ManyToOne
    private ProductEntity product;
    @OneToMany(mappedBy = "contractProduct")
    private List<ContractCollateralEntity> contractCollaterals;
}
