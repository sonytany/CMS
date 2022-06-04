package com.contract.management.system.repository;

import com.contract.management.system.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>
{
    List<ProductEntity> findByNameLike(String name);
}
