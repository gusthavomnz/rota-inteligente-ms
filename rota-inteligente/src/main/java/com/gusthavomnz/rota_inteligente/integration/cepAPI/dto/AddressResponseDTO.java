package com.gusthavomnz.rota_inteligente.integration.cepAPI.dto;


import com.gusthavomnz.rota_inteligente.integration.osrmAPI.dto.LocationDTO;

public record AddressResponseDTO(
        String cep,
        String state,
        String city,
        String neighborhood,
        String street,
        LocationDTO location
) {}
