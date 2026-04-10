package com.example.franchise.infrastructure.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import com.example.franchise.domain.repository.BranchRepository;
import com.example.franchise.domain.model.Branch;
import com.example.franchise.infrastructure.persistence.repository.SpringBranchRepository;
import com.example.franchise.infrastructure.persistence.entity.BranchEntity;

@Repository
@RequiredArgsConstructor
public class BranchRepositoryAdapter implements BranchRepository { // Dominio

    private final SpringBranchRepository repo; // Infraestructura (Spring Data)

    @Override
    public Flux<Branch> findByFranchiseId(Long franchiseId) {
        return repo.findByFranchiseId(franchiseId).map(this::toDomain);
    }

    private Branch toDomain(BranchEntity e) {
        return new Branch(e.getId(), e.getName(), e.getFranchiseId());
    }
}