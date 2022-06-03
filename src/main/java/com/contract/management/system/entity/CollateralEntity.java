package com.contract.management.system.entity;

import com.contract.management.system.dto.CollateralDto;
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
    private Product product;

    public CollateralDto toDto()
    {
        return CollateralDto.builder()
                .code(this.code)
                .name(this.name)
                .insurableMoney(this.insurableMoney)
                .standardMoney(this.standardMoney)
                .collateralProduct(new CollateralDto.CollateralProduct(product.getId(), product.getCode(), product.getName()))
                .build();
    }
}
