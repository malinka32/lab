package com.example.lab.Products;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDto toDto(Product product) {
        return new ProductDto(product.getName(), product.getAuthor(),
                product.getLanguage(), product.getWydawnictwo(), product.getCategory());
    }
}