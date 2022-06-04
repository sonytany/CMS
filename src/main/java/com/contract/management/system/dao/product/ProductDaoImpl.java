package com.contract.management.system.dao.product;

import com.contract.management.system.model.product.entiry.ProductEntity;
import com.contract.management.system.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao
{
    private final ProductRepository productRepository;

    @Override
    public ProductEntity save(ProductEntity entity)
    {
        return this.productRepository.save(entity);
    }

    @Override
    public void deleteById(int id)
    {
        this.productRepository.deleteById(id);
    }

    @Override
    public ProductEntity findById(int id)
    {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProductEntity> findAll()
    {
        return this.productRepository.findAll();
    }
}
