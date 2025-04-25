package com.example.Capstone.category.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UpdateCategoryCommand {
    private UUID id;
    private Category category;

    public UpdateCategoryCommand(UUID id, Category category) {
        this.id = id;
        this.category = category;
    }
}
