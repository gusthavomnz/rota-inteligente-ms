package com.gusthavomnz.rota_inteligente.core.DistributionCenter.service;


import com.gusthavomnz.rota_inteligente.core.DistributionCenter.dto.CreateDistributionCenterRequest;
import com.gusthavomnz.rota_inteligente.core.DistributionCenter.dto.DistributionCenterResponse;
import java.util.List;
import com.gusthavomnz.rota_inteligente.core.DistributionCenter.mapper.DistributionCenterMapper;
import com.gusthavomnz.rota_inteligente.core.DistributionCenter.model.DistributionCenter;
import com.gusthavomnz.rota_inteligente.core.DistributionCenter.repository.DistributionCenterRepository;
import com.gusthavomnz.rota_inteligente.integration.cepAPI.adapter.CepAdapter;
import com.gusthavomnz.rota_inteligente.integration.cepAPI.dto.AddressResponseDTO;
import com.gusthavomnz.rota_inteligente.integration.nominatumAPI.adapter.OpenStreetAdapter;
import com.gusthavomnz.rota_inteligente.integration.nominatumAPI.dto.CoordinatesResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class DistributionCenterService {

    private final DistributionCenterRepository distributionCenterRepository;
    private final CepAdapter cepAdapter;
    private final OpenStreetAdapter openStreetAdapter;
    private final DistributionCenterMapper distributionCenterMapper;

    public DistributionCenterService(DistributionCenterRepository distributionCenterRepository, CepAdapter cepAdapter, OpenStreetAdapter openStreetAdapter, DistributionCenterMapper distributionCenterMapper) {
        this.distributionCenterRepository = distributionCenterRepository;
        this.cepAdapter = cepAdapter;
        this.openStreetAdapter = openStreetAdapter;
        this.distributionCenterMapper = distributionCenterMapper;
    }

    public DistributionCenterResponse createDistributionCenter(CreateDistributionCenterRequest request) {
        AddressResponseDTO addressResponseDTO = cepAdapter.getAdress(request.cep());
        CoordinatesResponseDTO coordinates = openStreetAdapter.getCoordinates(addressResponseDTO.street(), addressResponseDTO.city(), addressResponseDTO.state(), addressResponseDTO.neighborhood());
        DistributionCenter newDistributionCenter = new DistributionCenter();
        newDistributionCenter.setName(request.name());
        newDistributionCenter.setDispatchFee(request.dispatchFee());
        newDistributionCenter.setKmValue(request.kmValue());
        newDistributionCenter.setLatitude(coordinates.latitude());
        newDistributionCenter.setLongitude(coordinates.longitude());
        DistributionCenter salvo = distributionCenterRepository.save(newDistributionCenter);
        return distributionCenterMapper.toResponse(salvo);
    }

    public List<DistributionCenterResponse> listDistributionCenters() {
        return distributionCenterMapper.toResponseList(distributionCenterRepository.findAll());
    }

}

