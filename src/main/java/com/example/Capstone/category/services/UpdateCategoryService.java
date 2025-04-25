package com.example.Capstone.category.services;

import com.example.Capstone.Command;
import com.example.Capstone.category.CategoryRepository;
import com.example.Capstone.category.model.Category;
import com.example.Capstone.category.model.CategoryDTO;
import com.example.Capstone.category.model.UpdateCategoryCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateCategoryService implements Command<UpdateCategoryCommand, CategoryDTO> {

    private final CategoryRepository categoryRepository;

    public UpdateCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<CategoryDTO> execute(UpdateCategoryCommand command){
        Optional<Category> categoryOptional = categoryRepository.findById(command.getId());
        if(categoryOptional.isPresent()){
            Category category = command.getCategory();
            category.setId(command.getId());
            categoryRepository.save(category);
            return ResponseEntity.ok(new CategoryDTO(category));
        }

        //This is where an exception for category not found would go.
        return null;
    }

}
