package com.gusthavomnz.rota_inteligente.core.product.controller;

import com.gusthavomnz.rota_inteligente.core.product.dto.CreateProductRequest;
import com.gusthavomnz.rota_inteligente.core.product.dto.ProductResponse;
import com.gusthavomnz.rota_inteligente.core.product.dto.UpdateProductRequest;
import com.gusthavomnz.rota_inteligente.core.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody @Valid CreateProductRequest request) {
        ProductResponse response = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id,
                                                   @RequestBody @Valid UpdateProductRequest request) {
        return ResponseEntity.ok(productService.updateProduct(id, request));
    }
}
