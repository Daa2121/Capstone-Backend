package com.example.Capstone.category;

import com.example.Capstone.category.model.Category;
import com.example.Capstone.category.model.CategoryDTO;
import com.example.Capstone.category.model.UpdateCategoryCommand;
import com.example.Capstone.category.services.*;
import com.example.Capstone.task.model.TaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CategoryController {

    private final CreateCategoryService createCategoryService;
    private final GetCategoriesService getCategoriesService;
    private final GetCategoryService getCategoryService;
    private final GetTasksInCategoryService getTasksInCategoryService;
    private final SearchCategoryService searchCategoryService;
    private final UpdateCategoryService updateCategoryService;
    private final DeleteCategoryService deleteCategoryService;

    public CategoryController(CreateCategoryService createCategoryService,
                              GetCategoriesService getCategoriesService,
                              GetCategoryService getCategoryService,
                              GetTasksInCategoryService getTasksInCategoryService,
                              SearchCategoryService searchCategoryService,
                              UpdateCategoryService updateCategoryService,
                              DeleteCategoryService deleteCategoryService) {
        this.createCategoryService = createCategoryService;
        this.getCategoriesService = getCategoriesService;
        this.getCategoryService = getCategoryService;
        this.getTasksInCategoryService = getTasksInCategoryService;
        this.searchCategoryService = searchCategoryService;
        this.updateCategoryService = updateCategoryService;
        this.deleteCategoryService = deleteCategoryService;
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

    @GetMapping("/category/{id}/tasks")
    public ResponseEntity<List<TaskDTO>> getTasksInCategoryByID(@PathVariable UUID id){
        return getTasksInCategoryService.execute(id);
    }

    @GetMapping("/category/search")
    public ResponseEntity<List<CategoryDTO>> searchCategoryByName(@RequestParam String name){
        return searchCategoryService.execute(name);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable UUID id, @RequestBody Category category){
        return updateCategoryService.execute(new UpdateCategoryCommand(id, category));
    }

    @DeleteMapping("/category/{id}")
    public  ResponseEntity<Void> deleteCategory(@PathVariable UUID id){
        return deleteCategoryService.execute(id);
    }
}
