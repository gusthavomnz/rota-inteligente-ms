package com.gusthavomnz.rota_inteligente.apis.tempControllerTests;

import com.gusthavomnz.rota_inteligente.apis.dto.AddressResponseDTO;
import com.gusthavomnz.rota_inteligente.apis.dto.CoordinatesResponseDTO;
import com.gusthavomnz.rota_inteligente.apis.port.CepPort;
import com.gusthavomnz.rota_inteligente.apis.port.OpenStreetPort;
import com.gusthavomnz.rota_inteligente.apis.port.OsrmPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class ControllerTesteRoteamento {

    private final CepPort cepPort;
    private final OpenStreetPort openStreetPort;
    private final OsrmPort osrmPort;

    @GetMapping("/rota-completa/{cep}")
    public ResponseEntity<List<Object>> testarFluxoCompleto(@PathVariable String cep) {
        List<Object> response = new ArrayList<>();

        // 1. BrasilAPI
        AddressResponseDTO endereco = cepPort.getAdress(cep);
        response.add(endereco);

        // 2. OpenStreetMap
        CoordinatesResponseDTO destino = openStreetPort.getCoordinates(
                endereco.street(),
                endereco.city(),
                endereco.state(),
                "Brazil"
        );
        response.add(destino);
        String coords = osrmPort.formatCoords(   "-10.9472", "-37.0731",
                destino.latitude(), destino.longitude());

        // 3. OSRM - peguei lat/long de aracaju por padrão para apenas testarmos a distancia de cidade inserida via post e aracaju
        Double distanciaKm = osrmPort.sendRequestRouteOsrm(coords);

        response.add(String.format("Distância Total: %.2f km", distanciaKm));

        return ResponseEntity.ok(response);
    }
}