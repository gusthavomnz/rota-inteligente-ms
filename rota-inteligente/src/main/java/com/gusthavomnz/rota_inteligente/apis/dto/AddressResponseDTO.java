package com.gusthavomnz.rota_inteligente.apis.dto;

public record AddressResponseDTO(
        String cep,
        String state,
        String city,
        String neighborhood,
        String street,
        LocationDTO location
) {}
