package com.gusthavomnz.rota_inteligente.core.DistributionCenter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import java.math.BigDecimal;

public record CreateDistributionCenterRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String name,

        @NotNull(message = "A latitude é obrigatória")
        @Digits(integer = 2, fraction = 8)
        BigDecimal latitude,

        @NotNull(message = "A longitude é obrigatória")
        @Digits(integer = 3, fraction = 8)
        BigDecimal longitude,

        @NotNull(message = "O valor por KM é obrigatório")
        @DecimalMin(value = "0.0", inclusive = false)
        BigDecimal kmValue,

        @NotNull(message = "A taxa de despacho é obrigatória")
        @DecimalMin(value = "0.0")
        BigDecimal dispatchFee
) {}
