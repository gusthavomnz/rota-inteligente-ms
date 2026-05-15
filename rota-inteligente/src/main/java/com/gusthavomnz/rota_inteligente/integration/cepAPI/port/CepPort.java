package com.gusthavomnz.rota_inteligente.integration.cepAPI.port;

import com.gusthavomnz.rota_inteligente.integration.cepAPI.dto.AddressResponseDTO;

public interface CepPort {
   AddressResponseDTO getAdress(String cep);
}
