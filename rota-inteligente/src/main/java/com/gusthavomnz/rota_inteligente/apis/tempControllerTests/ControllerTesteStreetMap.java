package com.gusthavomnz.rota_inteligente.apis.tempControllerTests;

import com.gusthavomnz.rota_inteligente.integration.cepAPI.dto.AddressResponseDTO;
import com.gusthavomnz.rota_inteligente.integration.nominatumAPI.dto.CoordinatesResponseDTO;
import com.gusthavomnz.rota_inteligente.integration.cepAPI.port.CepPort;
import com.gusthavomnz.rota_inteligente.integration.nominatumAPI.port.OpenStreetPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/testStreet")
@RequiredArgsConstructor
public class ControllerTesteStreetMap {

    private final CepPort cepPort;
    private final OpenStreetPort openStreetPort;

    @GetMapping("/conexao/{cep}")
    public ResponseEntity<List<Object>> testarConexao(@PathVariable String cep) {
        AddressResponseDTO endereco = cepPort.getAdress(cep);

        CoordinatesResponseDTO coordenadas = openStreetPort.getCoordinates(
                endereco.street(), endereco.city(), endereco.state(), "Brazil");

        List<Object> response = new ArrayList<>();
        response.add(Map.of("passo", "1 - BrasilAPI", "resultado", endereco));
        response.add(Map.of("passo", "2 - Nominatim", "resultado", coordenadas));

        return ResponseEntity.ok(response);
    }
}