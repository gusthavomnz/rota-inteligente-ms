package com.gusthavomnz.rota_inteligente.core.DistributionCenter.service;


import com.gusthavomnz.rota_inteligente.core.DistributionCenter.dto.CreateDistributionCenterRequest;
import com.gusthavomnz.rota_inteligente.core.DistributionCenter.dto.DistributionCenterResponse;
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
    private  final OpenStreetAdapter openStreetAdapter;

    public DistributionCenterService(DistributionCenterRepository distributionCenterRepository, CepAdapter cepAdapter, OpenStreetAdapter openStreetAdapter) {
        this.distributionCenterRepository = distributionCenterRepository;
        this.cepAdapter = cepAdapter;
        this.openStreetAdapter = openStreetAdapter;
    }

    public DistributionCenterResponse createDistributionCenter(CreateDistributionCenterRequest request) {
        AddressResponseDTO addressResponseDTO = cepAdapter.getAdress(request.cep());
        CoordinatesResponseDTO coordinates = openStreetAdapter.getCoordinates(addressResponseDTO.street(), addressResponseDTO.city(), addressResponseDTO.state(), addressResponseDTO.neighborhood());
        String latitude = coordinates.latitude();
        String longitude = coordinates.longitude();
        DistributionCenter newDistributionCenter = new DistributionCenter();
        newDistributionCenter.setName(request.name());
        newDistributionCenter.setDispatchFee(request.dispatchFee());
        newDistributionCenter.setKmValue(request.kmValue());
        newDistributionCenter.setLatitude(latitude);
        newDistributionCenter.setLongitude(longitude);
        DistributionCenter salvo = distributionCenterRepository.save(newDistributionCenter);
        DistributionCenterResponse response = new DistributionCenterResponse(salvo.getId(),salvo.getName(),salvo.getLatitude(),salvo.getLongitude(),salvo.getKmValue(),salvo.getDispatchFee());
        return response;
    }

}

