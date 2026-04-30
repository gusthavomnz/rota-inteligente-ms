package com.gusthavomnz.rota_inteligente.apis.adapter;

import com.gusthavomnz.rota_inteligente.apis.dto.AddressResponseDTO;
import com.gusthavomnz.rota_inteligente.apis.port.CepPort;
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
