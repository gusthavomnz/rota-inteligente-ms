package com.gusthavomnz.rota_inteligente.integration.cepAPI.adapter;

import com.gusthavomnz.rota_inteligente.integration.cepAPI.dto.AddressResponseDTO;
import com.gusthavomnz.rota_inteligente.integration.cepAPI.port.CepPort;
import org.springframework.stereotype.Component;

@Component
public class CepAdapter implements CepPort {

    private final CepClient cepClient;

    public CepAdapter(CepClient cepClient) {
        this.cepClient = cepClient;
    }

    public AddressResponseDTO getAdress(String cep) {
        return cepClient.getAdress(cep);
    }
}
