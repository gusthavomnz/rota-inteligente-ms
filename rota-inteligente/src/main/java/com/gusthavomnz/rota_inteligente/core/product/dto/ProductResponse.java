package com.gusthavomnz.rota_inteligente.core.product.dto;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        BigDecimal weight
) {}
