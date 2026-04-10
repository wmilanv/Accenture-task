package com.example.franchise.domain.repository;

import com.example.franchise.domain.model.Branch;
import reactor.core.publisher.Flux;

public interface BranchRepository {
    Flux<Branch> findByFranchiseId(Long franchiseId);
}