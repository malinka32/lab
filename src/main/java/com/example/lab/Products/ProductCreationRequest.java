package com.example.lab.Products;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
public final class ProductCreationRequest {

    @NotNull
    private final String name;

    @NotNull
    private final String author;

    @NotNull
    private final String language;

    @NotNull
    private final String wydawnictwo;

    @NotNull
    @Positive
    private final Long categoryId;

    @JsonCreator
    public ProductCreationRequest(
            @JsonProperty("name") String name,
            @JsonProperty("author") String author,
            @JsonProperty("language") String language,
            @JsonProperty("wydawnictwo") String wydawnictwo,
            @JsonProperty("categoryId") Long categoryId) {
        this.name = name;
        this.author = author;
        this.language = language;
        this.wydawnictwo = wydawnictwo;
        this.categoryId = categoryId;
    }
}
