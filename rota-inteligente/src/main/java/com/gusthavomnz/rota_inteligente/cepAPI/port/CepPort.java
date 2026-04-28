package com.gusthavomnz.rota_inteligente.cepAPI.port;

import com.gusthavomnz.rota_inteligente.cepAPI.dto.AddressResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CepPort {
   AddressResponseDTO getAdress(String cep);
}
