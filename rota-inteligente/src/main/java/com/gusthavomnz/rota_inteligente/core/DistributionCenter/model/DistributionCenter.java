package com.gusthavomnz.rota_inteligente.core.DistributionCenter.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "distribution_center")
@Data
public class DistributionCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "latitude", nullable = false, precision = 10, scale = 8)
    private BigDecimal latitude;

    @Column(name = "longitude", nullable = false, precision = 11, scale = 8)
    private BigDecimal longitude;

    @Column(name = "km_value", nullable = false, precision = 10, scale = 2)
    private BigDecimal kmValue;

    @Column(name = "dispatch_fee", nullable = false, precision = 10, scale = 2)
    private BigDecimal dispatchFee;
}
