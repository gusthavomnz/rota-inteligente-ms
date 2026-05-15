package com.gusthavomnz.rota_inteligente.integration.cepAPI.adapter;

import com.gusthavomnz.rota_inteligente.integration.cepAPI.dto.AddressResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BrasilAPI-api", url = "https://brasilapi.com.br/api/cep/v2")
public interface CepClient {


    @GetMapping("/{cep}")
    AddressResponseDTO getAdress(@PathVariable("cep") String cep);
}
