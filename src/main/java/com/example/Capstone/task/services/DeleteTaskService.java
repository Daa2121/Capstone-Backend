package com.example.Capstone.task.services;

import com.example.Capstone.Command;
import com.example.Capstone.task.TaskRepository;
import com.example.Capstone.task.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeleteTaskService implements Command<UUID, Void> {
    private final TaskRepository taskRepository;

    public DeleteTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ResponseEntity<Void> execute(UUID id){
        Optional<Task> taskOptional = taskRepository.findById(id);
        if(taskOptional.isPresent()){
            taskRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        //This is where a task not found exception would go.
        return null;
    }
}
