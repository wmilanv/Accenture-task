
package com.example.franchise.infrastructure.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import com.example.franchise.domain.repository.ProductRepository;
import com.example.franchise.domain.model.Product;
import com.example.franchise.infrastructure.persistence.repository.SpringProductRepository;
import com.example.franchise.infrastructure.persistence.entity.ProductEntity;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final SpringProductRepository repo;

    @Override
    public Flux<Product> findByBranchId(Long branchId) {
        return repo.findByBranchId(branchId).map(this::toDomain);
    }

    @Override
    public Flux<Product> findAll() {
        return repo.findAll().map(this::toDomain);
    }

    private Product toDomain(ProductEntity e) {
        return new Product(e.getId(), e.getName(), e.getStock(), e.getBranchId());
    }
}
