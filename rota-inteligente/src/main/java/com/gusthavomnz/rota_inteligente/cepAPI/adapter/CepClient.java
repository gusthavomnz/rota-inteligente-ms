package com.gusthavomnz.rota_inteligente.cepAPI.adapter;

import com.gusthavomnz.rota_inteligente.cepAPI.dto.AddressResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "cep-api", url = "https://brasilapi.com.br/api/cep/v2")
public interface CepClient {


    @GetMapping("/{cep}")
    AddressResponseDTO getAdress(@PathVariable("cep") String cep);
}
