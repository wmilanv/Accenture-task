
package com.example.franchise.infrastructure.persistence.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import com.example.franchise.infrastructure.persistence.entity.ProductEntity;

public interface SpringProductRepository extends ReactiveCrudRepository<ProductEntity, Long> {
    Flux<ProductEntity> findByBranchId(Long branchId);
}
