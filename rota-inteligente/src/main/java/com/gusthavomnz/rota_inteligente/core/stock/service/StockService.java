package com.gusthavomnz.rota_inteligente.core.stock.service;

import com.gusthavomnz.rota_inteligente.core.stock.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
}
