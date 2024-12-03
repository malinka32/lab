package com.example.lab.Products;

import com.example.lab.Category.Category;
import lombok.Builder;

@Builder
public record ProductDto(String name, String author, String language, String wydawnictwo, Category category) {
}
