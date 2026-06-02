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

        @NotBlank(message = "O cep é obrigatório")
        String cep,

        @NotNull(message = "O valor por KM é obrigatório")
        BigDecimal kmValue,

        @NotNull(message = "A taxa de despacho é obrigatória")
        BigDecimal dispatchFee
) {}
