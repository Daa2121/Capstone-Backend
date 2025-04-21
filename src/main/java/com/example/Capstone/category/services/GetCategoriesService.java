package com.example.Capstone.category.services;

import com.example.Capstone.Query;
import com.example.Capstone.category.model.Category;
import com.example.Capstone.category.model.CategoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCategoriesService implements Query<Void, List<CategoryDTO>> {

    private CategoryRepository categoryRepository;

    public GetCategoriesService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> execute(Void input) {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = categories.stream().map(CategoryDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(categoryDTOS);
    }
}
