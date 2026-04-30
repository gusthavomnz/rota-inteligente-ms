package com.gusthavomnz.rota_inteligente.apis.adapter;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "osrm-api", url = "http://router.project-osrm.org/route/v1/driving/")
public interface OsrmClient {

}
