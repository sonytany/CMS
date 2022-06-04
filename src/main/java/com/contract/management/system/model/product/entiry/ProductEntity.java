package com.contract.management.system.model.product.entiry;

import com.contract.management.system.model.collateral.entity.CollateralEntity;
import com.contract.management.system.model.contract.entity.ContractCollateralEntity;
import com.contract.management.system.model.contract.entity.ContractProductEntity;
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
@Table(name = "product")
public class ProductEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String code;
    private String name;

    @OneToMany(mappedBy = "product")
    private List<CollateralEntity> collaterals;
    @OneToMany(mappedBy = "product")
    private List<ContractProductEntity> contractProducts;
    @OneToMany(mappedBy = "product")
    private List<ContractCollateralEntity> contractCollateralEntities;
}
