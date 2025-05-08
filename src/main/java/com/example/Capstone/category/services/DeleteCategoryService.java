    package com.example.Capstone.category.services;

    import com.example.Capstone.Command;
    import com.example.Capstone.category.CategoryRepository;
    import com.example.Capstone.category.model.Category;
    import com.example.Capstone.task.TaskRepository;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Service;
    import org.springframework.web.server.ResponseStatusException;

    import java.util.Optional;
    import java.util.UUID;

    @Service
    public class DeleteCategoryService implements Command<UUID, Void> {
        private final CategoryRepository categoryRepository;
        private final TaskRepository taskRepository;

        public DeleteCategoryService(CategoryRepository categoryRepository, TaskRepository taskRepository) {
            this.categoryRepository = categoryRepository;
            this.taskRepository = taskRepository;
        }

        @Override
        public ResponseEntity<Void> execute(UUID id){
            Optional<Category> categoryOptional = categoryRepository.findById(id);
            if(categoryOptional.isPresent()){
                if(!taskRepository.existsByCategoryId(id)) {
                    categoryRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                }
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Cannot delete category: Tasks are still assigned.");
            }

            //This is where a category not found exception would go.
            return null;
        }
    }
