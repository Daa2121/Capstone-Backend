package com.example.Capstone.category.services;

import com.example.Capstone.Query;
import com.example.Capstone.task.model.TaskDTO;
import com.example.Capstone.task.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GetTasksInCategoryService implements Query<UUID, List<TaskDTO>> {

    private final TaskRepository taskRepository;

    public GetTasksInCategoryService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ResponseEntity<List<TaskDTO>> execute(UUID categoryId) {
        List<TaskDTO> tasks = taskRepository
                .findAllByCategoryId(categoryId)
                .stream()
                .map(TaskDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(tasks);
    }
}
