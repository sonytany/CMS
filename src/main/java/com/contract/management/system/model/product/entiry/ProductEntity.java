package com.contract.management.system.model.product.entiry;

import com.contract.management.system.model.collateral.entity.CollateralEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "product")
@Table(name = "product")
public class ProductEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String code;
    private String name;
    private int minPeriod;
    private int maxPeriod;

    @OneToMany(mappedBy = "product")
    private List<CollateralEntity> collaterals;
}
