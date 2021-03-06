package com.contract.management.system.repository;

import com.contract.management.system.model.product.entiry.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>
{
    List<ProductEntity> findByNameLike(String name);
}
