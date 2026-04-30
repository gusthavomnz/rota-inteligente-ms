package com.gusthavomnz.rota_inteligente.apis.port;
import com.gusthavomnz.rota_inteligente.apis.dto.CoordinatesResponseDTO;

import java.util.List;

public interface OpenStreetPort {
    CoordinatesResponseDTO getCoordinates(String street, String city, String state, String country);
}
