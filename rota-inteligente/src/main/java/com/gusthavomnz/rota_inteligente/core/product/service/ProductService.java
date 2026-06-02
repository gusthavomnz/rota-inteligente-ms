package com.gusthavomnz.rota_inteligente.core.product.service;

import com.gusthavomnz.rota_inteligente.core.product.Product;
import com.gusthavomnz.rota_inteligente.core.product.dto.CreateProductRequest;
import com.gusthavomnz.rota_inteligente.core.product.dto.ProductResponse;
import com.gusthavomnz.rota_inteligente.core.product.dto.UpdateProductRequest;
import com.gusthavomnz.rota_inteligente.core.product.mapper.ProductMapper;
import com.gusthavomnz.rota_inteligente.core.product.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse createProduct(CreateProductRequest request) {
        Product saved = productRepository.save(productMapper.toEntity(request));
        return productMapper.toResponse(saved);
    }

    public ProductResponse updateProduct(Long id, UpdateProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com id: " + id));
        product.setName(request.name());
        product.setWeight(request.weight());
        Product saved = productRepository.save(product);
        return productMapper.toResponse(saved);
    }
}
