
package com.example.franchise.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
// import reactor.core.publisher.Mono;
import com.example.franchise.domain.repository.ProductRepository;
import com.example.franchise.domain.repository.BranchRepository;
import com.example.franchise.domain.model.Product;

@Service
@RequiredArgsConstructor
public class GetTopProductByBranchUseCase {

    private final ProductRepository productRepo;
    private final BranchRepository branchRepo; // <-- Necesitas este ahora

    public Flux<Product> execute(Long franchiseId) {
        return branchRepo.findByFranchiseId(franchiseId) // Paso 1: Flujo de sucursales
            .flatMap(branch -> 
                productRepo.findByBranchId(branch.getId()) // Paso 2: Flujo de productos por sucursal
                    .reduce((p1, p2) -> p1.getStock() > p2.getStock() ? p1 : p2) // Paso 3: El mayor
            );
    }
}
