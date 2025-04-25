package com.example.Capstone.category.services;

import com.example.Capstone.Query;
import com.example.Capstone.category.CategoryRepository;
import com.example.Capstone.category.model.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchCategoryService implements Query<String, List<CategoryDTO>> {
    private final CategoryRepository categoryRepository;

    public SearchCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> execute(String name) {
        return ResponseEntity.ok(categoryRepository.findByNameOrDescriptionContaining(name)
                .stream()
                .map(CategoryDTO::new)
                .toList());
    }
}
