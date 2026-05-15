package com.gusthavomnz.rota_inteligente.integration.nominatumAPI.adapter;

import com.gusthavomnz.rota_inteligente.integration.nominatumAPI.dto.CoordinatesResponseDTO;
import com.gusthavomnz.rota_inteligente.integration.nominatumAPI.port.OpenStreetPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OpenStreetAdapter implements OpenStreetPort {

    private final OpenStreetClient openStreetClient;

    public OpenStreetAdapter(OpenStreetClient openStreetClient) {
        this.openStreetClient = openStreetClient;
    }


    public CoordinatesResponseDTO getCoordinates(String street, String city, String state, String country) {
        try {
            List<CoordinatesResponseDTO> results = openStreetClient.getCoordinates(
                    street,
                    city,
                    state,
                    country,
                    "rota-inteligente-ms || academic project by gusthavogp123@gmail.com"
            );

            if (results == null || results.isEmpty()) {
                return null;
            }

            CoordinatesResponseDTO primeiroResultado = results.get(0);

            return new CoordinatesResponseDTO(
                    primeiroResultado.latitude(),
                    primeiroResultado.longitude()
            );

        } catch (Exception e) {
            throw new RuntimeException("Falha na geolocalização externa: " + e.getMessage());
        }
    }
}


