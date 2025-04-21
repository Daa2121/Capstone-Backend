package com.example.Capstone.category.model;

import lombok.Data;

import java.util.UUID;

@Data
public class CategoryDTO {
    private UUID id;
    private String name;
    private String description;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.description = category.getDescription();
    }
}
