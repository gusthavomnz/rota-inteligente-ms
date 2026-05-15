package com.gusthavomnz.rota_inteligente.integration.osrmAPI.adapter;

import com.gusthavomnz.rota_inteligente.integration.osrmAPI.dto.OsrmResponseDTO;
import com.gusthavomnz.rota_inteligente.integration.osrmAPI.port.OsrmPort;
import org.springframework.stereotype.Component;

@Component
public class OsrmAdapter implements OsrmPort {

    private final OsrmClient osrmClient;

    public OsrmAdapter(OsrmClient osrmClient) {
        this.osrmClient = osrmClient;
    }

    @Override
    public String formatCoords(String lat1, String lon1, String lat2, String lon2) {
        // Regra: lon,lat;lon,lat
        String coords = String.format("%s,%s;%s,%s", lon1, lat1, lon2, lat2);
        return coords;
    }

    @Override
    public Double sendRequestRouteOsrm(String coords) {
        try {
            OsrmResponseDTO response = osrmClient.getRoute(coords);
            if (response != null && response.routes() != null && !response.routes().isEmpty()) {
                // Pega a distância em metros e converte para KM
                return response.routes().get(0).distance() / 1000.0;
            }
        } catch (Exception e) {

    }
        return 0.0;
    }
}
