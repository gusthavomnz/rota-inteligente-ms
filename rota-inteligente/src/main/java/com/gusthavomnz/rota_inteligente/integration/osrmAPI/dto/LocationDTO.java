package com.gusthavomnz.rota_inteligente.integration.osrmAPI.dto;

import com.gusthavomnz.rota_inteligente.integration.nominatumAPI.dto.CoordinatesResponseDTO;

public record LocationDTO(
        CoordinatesResponseDTO coordinates
) {}
