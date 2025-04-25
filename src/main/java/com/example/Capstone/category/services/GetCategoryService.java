package com.example.Capstone.category.services;

import com.example.Capstone.Query;
import com.example.Capstone.category.CategoryRepository;
import com.example.Capstone.category.model.Category;
import com.example.Capstone.category.model.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetCategoryService implements Query<UUID, CategoryDTO> {
    private final CategoryRepository categoryRepository;

    public GetCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<CategoryDTO> execute(UUID input) {
        // 'Optional' accounts for if you can find it or not
        Optional<Category> categoryOptional = categoryRepository.findById(input);
        if (categoryOptional.isPresent()) {
            return ResponseEntity.ok(new CategoryDTO(categoryOptional.get()));
        }

        //TODO Add exception for category not found
        return null;
    }
}