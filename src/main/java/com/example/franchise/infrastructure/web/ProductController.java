
package com.example.franchise.infrastructure.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
// import reactor.core.publisher.Mono;
import com.example.franchise.application.usecase.GetTopProductByBranchUseCase;
import com.example.franchise.domain.repository.ProductRepository;
import com.example.franchise.domain.model.Product;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final GetTopProductByBranchUseCase useCase;
    private final ProductRepository repo;

    @GetMapping
    public Flux<Product> all() {
        return repo.findAll();
    }

    @GetMapping("/top/{branchId}")
    public Flux<Product> top(@PathVariable Long branchId) {
        return useCase.execute(branchId);
    }
}
