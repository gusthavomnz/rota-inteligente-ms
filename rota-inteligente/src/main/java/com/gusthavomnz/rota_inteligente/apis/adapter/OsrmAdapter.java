package com.gusthavomnz.rota_inteligente.apis.adapter;

import com.gusthavomnz.rota_inteligente.apis.dto.OsrmResponseDTO;
import com.gusthavomnz.rota_inteligente.apis.port.OsrmPort;
import org.springframework.stereotype.Component;

@Component
public class OsrmAdapter implements OsrmPort {

    private final OsrmClient osrmClient;

    public OsrmAdapter(OsrmClient osrmClient) {
        this.osrmClient = osrmClient;
    }

@Override
    public Double getRoute(String lat1, String lon1, String lat2, String lon2) {
        // Regra: lon,lat;lon,lat
        String coords = String.format("%s,%s;%s,%s", lon1, lat1, lon2, lat2);

        // O Feign chama a API usando essa String no Path
        OsrmResponseDTO response = osrmClient.getRoute(coords);

        if (response != null && response.routes() != null && !response.routes().isEmpty()) {
            // Pega a distância em metros e converte para KM
            return response.routes().get(0).distance() / 1000.0;
        }

        return 0.0;
    }
}
