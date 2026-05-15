package com.gusthavomnz.rota_inteligente.integration.nominatumAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CoordinatesResponseDTO(
        @JsonProperty("lat") String latitude,
        @JsonProperty("lon") String longitude)
{}
