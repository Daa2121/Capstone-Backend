package com.example.Capstone.task.services;

import com.example.Capstone.Command;
import com.example.Capstone.category.CategoryRepository;
import com.example.Capstone.category.model.Category;
import com.example.Capstone.task.TaskRepository;
import com.example.Capstone.task.model.Task;
import com.example.Capstone.task.model.TaskDTO;
import com.example.Capstone.task.model.UpdateTaskCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UpdateTaskService implements Command<UpdateTaskCommand, TaskDTO> {
    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;

    public UpdateTaskService(TaskRepository taskRepository, CategoryRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<TaskDTO> execute(UpdateTaskCommand command){
        Optional<Task> taskOptional = taskRepository.findById(command.getId());
        if(taskOptional.isPresent()){
            Task task = command.getTask();
            task.setId(command.getId());

            //Display category name instead of null or category ID for response
            if (task.getCategory() != null && task.getCategory().getId() != null) {
                Category fullCategory = categoryRepository.findById(task.getCategory().getId())
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.BAD_REQUEST, "Invalid category ID"));
                task.setCategory(fullCategory);
            }

            taskRepository.save(task);
            return ResponseEntity.ok(new TaskDTO(task));
        }

        //This is where an exception for task not found would go.
        return null;
    }
}
