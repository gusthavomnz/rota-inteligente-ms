package com.gusthavomnz.rota_inteligente.core.DistributionCenter.service;


import com.gusthavomnz.rota_inteligente.core.DistributionCenter.dto.CreateDistributionCenterRequest;
import com.gusthavomnz.rota_inteligente.core.DistributionCenter.model.DistributionCenter;
import com.gusthavomnz.rota_inteligente.core.DistributionCenter.repository.DistributionCenterRepository;
import org.springframework.stereotype.Service;

@Service
public class DistributionCenterService {

    private final DistributionCenterRepository distributionCenterRepository;

    public DistributionCenterService(DistributionCenterRepository distributionCenterRepository) {
        this.distributionCenterRepository = distributionCenterRepository;
    }

    public DistributionCenter createDistributionCenter(CreateDistributionCenterRequest request) {
        return null;
    }

}
