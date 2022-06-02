package com.contract.management.system.repository;

import com.contract.management.system.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer>
{
    List<Product> findByNameLike(String name);
}
