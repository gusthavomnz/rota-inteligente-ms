package com.gusthavomnz.rota_inteligente.apis.tempControllerTests;

import com.gusthavomnz.rota_inteligente.integration.cepAPI.dto.AddressResponseDTO;
import com.gusthavomnz.rota_inteligente.integration.cepAPI.port.CepPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testBrasil")
public class ControllerTesteBrasilApi {

    private final CepPort cepPort;

    public ControllerTesteBrasilApi(CepPort cepPort) {
        this.cepPort = cepPort;
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<AddressResponseDTO> testarCep(@PathVariable String cep) {
        return ResponseEntity.ok(cepPort.getAdress(cep));
    }
}
