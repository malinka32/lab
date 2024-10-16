package com.example.lab.Products;

import com.example.lab.Category.Category;

public record ProductDto(String name, String author, String language, String wydawnictwo, Category category) {
}