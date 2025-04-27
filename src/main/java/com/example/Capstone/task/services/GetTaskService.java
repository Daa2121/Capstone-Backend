package com.example.Capstone.task.services;

import com.example.Capstone.Query;
import com.example.Capstone.task.TaskRepository;
import com.example.Capstone.task.model.Task;
import com.example.Capstone.task.model.TaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetTaskService implements Query<UUID, TaskDTO> {
    private final TaskRepository taskRepository;

    public GetTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ResponseEntity<TaskDTO> execute(UUID input) {
        // 'Optional' accounts for if you can find it or not
        Optional<Task> taskOptional = taskRepository.findById(input);
        if(taskOptional.isPresent()){
            return ResponseEntity.ok(new TaskDTO(taskOptional.get()));
        }

        //TODO Add exception for task not found
        return null;
    }
}
