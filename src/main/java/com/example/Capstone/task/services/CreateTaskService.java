package com.example.Capstone.task.services;

import com.example.Capstone.Command;
import com.example.Capstone.category.model.Category;
import com.example.Capstone.category.CategoryRepository;
import com.example.Capstone.task.TaskRepository;
import com.example.Capstone.task.model.Task;
import com.example.Capstone.task.model.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CreateTaskService implements Command<Task, TaskDTO> {

    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;

    public CreateTaskService(
            TaskRepository taskRepository,
            CategoryRepository categoryRepository
    ) {
        this.taskRepository   = taskRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<TaskDTO> execute(Task task) {
        // if the client sent { "category": { "id": "..." } }, lookup the full Category
        if (task.getCategory() != null && task.getCategory().getId() != null) {
            Category fullCategory = categoryRepository.findById(task.getCategory().getId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "Invalid category ID"));
            task.setCategory(fullCategory);
        }

        Task saved = taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new TaskDTO(saved));
    }
}
