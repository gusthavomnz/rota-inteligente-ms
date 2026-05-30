package com.gusthavomnz.rota_inteligente.core.product.mapper;

import com.gusthavomnz.rota_inteligente.core.product.Product;
import com.gusthavomnz.rota_inteligente.core.product.dto.CreateProductRequest;
import com.gusthavomnz.rota_inteligente.core.product.dto.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    public Product toEntity(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.name());
        product.setWeight(request.weight());
        return product;
    }

    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getWeight()
        );
    }

    public List<ProductResponse> toResponseList(List<Product> products) {
        return products.stream().map(this::toResponse).toList();
    }
}
