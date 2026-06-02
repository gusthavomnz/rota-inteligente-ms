package com.gusthavomnz.rota_inteligente.core.product.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record UpdateProductRequest(

        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String name,

        @NotNull(message = "O peso é obrigatório")
        @DecimalMin(value = "0.001", message = "O peso deve ser maior que zero")
        BigDecimal weight
) {}
