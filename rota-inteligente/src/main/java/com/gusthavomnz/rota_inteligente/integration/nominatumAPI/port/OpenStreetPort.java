package com.gusthavomnz.rota_inteligente.integration.nominatumAPI.port;
import com.gusthavomnz.rota_inteligente.integration.nominatumAPI.dto.CoordinatesResponseDTO;

public interface OpenStreetPort {
    CoordinatesResponseDTO getCoordinates(String street, String city, String state, String country);
}
