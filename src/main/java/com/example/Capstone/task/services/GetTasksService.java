package com.example.Capstone.task.services;

import com.example.Capstone.Query;
import com.example.Capstone.task.TaskRepository;
import com.example.Capstone.task.model.Task;
import com.example.Capstone.task.model.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTasksService implements Query<Void, List<TaskDTO>> {

    private final TaskRepository taskRepository;

    public GetTasksService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ResponseEntity<List<TaskDTO>> execute(Void input) {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDTO> taskDTOS = tasks.stream().map(TaskDTO::new).toList();

       return ResponseEntity.status(HttpStatus.OK).body(taskDTOS);
    }
}
