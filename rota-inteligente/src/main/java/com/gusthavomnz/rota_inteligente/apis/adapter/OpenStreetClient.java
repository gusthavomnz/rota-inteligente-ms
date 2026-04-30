package com.gusthavomnz.rota_inteligente.apis.adapter;

import com.gusthavomnz.rota_inteligente.apis.dto.CoordinatesResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "OpenStreet-api", url = "https://nominatim.openstreetmap.org")
public interface OpenStreetClient {

    @GetMapping("/search?format=json&limit=1")
    List<CoordinatesResponseDTO> getCoordinates(
            @RequestParam("street") String street,
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("country") String country,
            @RequestHeader("User-Agent") String userAgent
    );
}
