package com.gusthavomnz.rota_inteligente.apis.adapter;


import com.gusthavomnz.rota_inteligente.apis.dto.OsrmResponseDTO;
import com.gusthavomnz.rota_inteligente.apis.dto.RouteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "osrm-api", url = "http://router.project-osrm.org/route/v1/driving/")
public interface OsrmClient {

    @GetMapping("/{coords}?overview=false")
    OsrmResponseDTO getRoute(@PathVariable("coords") String coordinatesRoutes);
}
