
package com.example.franchise.infrastructure.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table("product")
public class ProductEntity {
    @Id
    private Long id;
    private String name;
    private Integer stock;
    private Long branchId;
}
