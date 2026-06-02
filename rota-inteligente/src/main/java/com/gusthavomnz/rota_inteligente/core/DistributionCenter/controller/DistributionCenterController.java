package com.gusthavomnz.rota_inteligente.core.DistributionCenter.controller;

import com.gusthavomnz.rota_inteligente.core.DistributionCenter.dto.CreateDistributionCenterRequest;
import com.gusthavomnz.rota_inteligente.core.DistributionCenter.dto.DistributionCenterResponse;
import com.gusthavomnz.rota_inteligente.core.DistributionCenter.service.DistributionCenterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/distribution-centers")
@RequiredArgsConstructor
public class DistributionCenterController {

    private final DistributionCenterService service;

    @PostMapping
    public ResponseEntity<DistributionCenterResponse> create(
            @RequestBody @Valid CreateDistributionCenterRequest request) {

        DistributionCenterResponse response = service.createDistributionCenter(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}