
package com.example.franchise.domain.repository;

import reactor.core.publisher.Flux;
import com.example.franchise.domain.model.Product;

public interface ProductRepository {
    Flux<Product> findByBranchId(Long branchId);
    Flux<Product> findAll();
}
