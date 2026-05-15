package com.gusthavomnz.rota_inteligente.core.DistributionCenter.dto;

import java.math.BigDecimal;

public record DistributionCenterResponse(
        Long id,
        String name,
        BigDecimal latitude,
        BigDecimal longitude,
        BigDecimal kmValue,
        BigDecimal dispatchFee
) {}
