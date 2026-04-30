package com.gusthavomnz.rota_inteligente.apis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record CoordinatesResponseDTO(
        @JsonProperty("lat") String latitude,
        @JsonProperty("lon") String longitude)
{}
