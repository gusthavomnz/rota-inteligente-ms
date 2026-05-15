package com.gusthavomnz.rota_inteligente.integration.osrmAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RouteDTO(
        Double distance
) {}
// ^ campos da lista routes[]
