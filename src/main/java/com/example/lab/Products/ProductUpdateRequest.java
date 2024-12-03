package com.example.lab.Products;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductUpdateRequest {
    private final String name;
    private final String author;
    private final String language;
    private final String wydawnictwo;

    public ProductUpdateRequest(
            @JsonProperty("name") String name,
            @JsonProperty("author") String author,
            @JsonProperty("language") String language,
            @JsonProperty("wydawnictwo") String wydawnictwo) {
        this.name = name;
        this.author = author;
        this.language = language;
        this.wydawnictwo = wydawnictwo;
    }
}
