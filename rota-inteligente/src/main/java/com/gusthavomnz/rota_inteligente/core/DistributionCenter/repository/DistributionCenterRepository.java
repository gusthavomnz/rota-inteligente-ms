package com.gusthavomnz.rota_inteligente.core.DistributionCenter.repository;

import com.gusthavomnz.rota_inteligente.core.DistributionCenter.model.DistributionCenter;
import com.gusthavomnz.rota_inteligente.integration.osrmAPI.dto.LocationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionCenterRepository extends JpaRepository<DistributionCenter, LocationDTO> {
}
