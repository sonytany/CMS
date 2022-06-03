package com.contract.management.system.repository;

import com.contract.management.system.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    List<Product> findByNameLike(String name);
}
