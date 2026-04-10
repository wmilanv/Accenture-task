package com.example.franchise.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("branch")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchEntity {
    @Id
    private Long id;
    private String name;
    private Long franchiseId;
}