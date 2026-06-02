package com.gusthavomnz.rota_inteligente.core.DistributionCenter.mapper;

import com.gusthavomnz.rota_inteligente.core.DistributionCenter.dto.CreateDistributionCenterRequest;
import com.gusthavomnz.rota_inteligente.core.DistributionCenter.dto.DistributionCenterResponse;
import com.gusthavomnz.rota_inteligente.core.DistributionCenter.model.DistributionCenter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DistributionCenterMapper {

    public DistributionCenter toEntity(CreateDistributionCenterRequest request) {
        return null;
    }

    public DistributionCenterResponse toResponse(DistributionCenter dc) {
        return new DistributionCenterResponse(
                dc.getId(),
                dc.getName(),
                dc.getLatitude(),
                dc.getLongitude(),
                dc.getKmValue(),
                dc.getDispatchFee()
        );
    }

    public List<DistributionCenterResponse> toResponseList(List<DistributionCenter> dcs) {
        return dcs.stream().map(this::toResponse).toList();
    }
}
