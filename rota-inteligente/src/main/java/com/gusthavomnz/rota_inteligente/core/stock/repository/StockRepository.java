package com.gusthavomnz.rota_inteligente.core.stock.repository;

import com.gusthavomnz.rota_inteligente.core.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findByDistributionCenterId(Long distributionCenterId);
}
