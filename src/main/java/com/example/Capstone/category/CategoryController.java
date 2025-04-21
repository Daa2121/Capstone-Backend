package com.example.Capstone.category;

import com.example.Capstone.category.model.Category;
import com.example.Capstone.category.model.CategoryDTO;
import com.example.Capstone.category.services.CreateCategoryService;
import com.example.Capstone.category.services.GetCategoriesService;
import com.example.Capstone.category.services.GetCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CategoryController {

    private final CreateCategoryService createCategoryService;
    private final GetCategoriesService getCategoriesService;
    private final GetCategoryService getCategoryService;

    public CategoryController(CreateCategoryService createCategoryService, GetCategoriesService getCategoriesService, GetCategoryService getCategoryService) {
        this.createCategoryService = createCategoryService;
        this.getCategoriesService = getCategoriesService;
        this.getCategoryService = getCategoryService;
    }

    @PostMapping("/category")
    public  ResponseEntity<CategoryDTO> createTask(@RequestBody Category category){
        return createCategoryService.execute(category);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getCategories(){
        return getCategoriesService.execute(null);
    }

    @GetMapping("/category/{id}")
    public  ResponseEntity<CategoryDTO> getCategoryByID(@PathVariable UUID id){
        return getCategoryService.execute(id);
    }
}
