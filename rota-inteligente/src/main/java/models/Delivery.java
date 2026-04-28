package models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery")
@Data
public class Delivery {
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

    @Column(name = "distance_km", nullable = false, precision = 10, scale = 2)
    private BigDecimal distanceKm;

    @Column(name = "total_shipping_value", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalShippingValue;

    @Column(name = "destination_zip_code", nullable = false, length = 9)
    private String destinationZipCode;

    @Column(name = "destination_latitude", nullable = false, precision = 10, scale = 8)
    private BigDecimal destinationLatitude;

    @Column(name = "destination_longitude", nullable = false, precision = 11, scale = 8)
    private BigDecimal destinationLongitude;

    @Column(name = "weight_surcharge", nullable = false)
    private Boolean weightSurcharge;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}