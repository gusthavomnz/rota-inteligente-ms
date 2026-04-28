package com.gusthavomnz.rota_inteligente.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "stock", uniqueConstraints = {
        @UniqueConstraint(name = "UQ_stock_product_cd", columnNames = {"product_id", "cd_id"})
})
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_id", nullable = false)
    private DistributionCenter distributionCenter;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}