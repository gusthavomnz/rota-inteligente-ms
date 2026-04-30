package com.gusthavomnz.rota_inteligente.apis.port;

import com.gusthavomnz.rota_inteligente.apis.dto.AddressResponseDTO;

public interface CepPort {
   AddressResponseDTO getAdress(String cep);
}
