package com.gusthavomnz.rota_inteligente.integration.osrmAPI.adapter;


import com.gusthavomnz.rota_inteligente.integration.osrmAPI.dto.OsrmResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "osrm-api", url = "http://router.project-osrm.org/route/v1/driving/")
public interface OsrmClient {

    @GetMapping("/{coords}?overview=false")
    OsrmResponseDTO getRoute(@PathVariable("coords") String coordinatesRoutes);
}
