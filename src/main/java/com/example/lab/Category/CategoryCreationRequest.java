package com.example.lab.Category;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryCreationRequest {
    @NotBlank
    private final String name;

    private final String description;

    @JsonCreator
    public CategoryCreationRequest(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description) {
        this.name = name;
        this.description = description;
    }
}
