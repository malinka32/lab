package com.example.lab.Products;

public record ProductRequest(
        String name,
        String author,
        String language,
        String wydawnictwo,
        Long categoryId
) {}
