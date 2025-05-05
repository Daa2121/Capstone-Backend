package com.example.Capstone.task;

import com.example.Capstone.task.model.Task;
import com.example.Capstone.task.model.TaskDTO;
import com.example.Capstone.task.model.UpdateTaskCommand;
import com.example.Capstone.task.services.CreateTaskService;
import com.example.Capstone.task.services.GetTaskService;
import com.example.Capstone.task.services.GetTasksService;
import com.example.Capstone.task.services.UpdateTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TaskController {
    private final CreateTaskService createTaskService;
    private final GetTasksService getTasksService;
    private final GetTaskService getTaskService;
    private final UpdateTaskService updateTaskService;

   public TaskController(CreateTaskService createTaskService,
                         GetTasksService getTasksService,
                         GetTaskService getTaskService,
                         UpdateTaskService updateTaskService ) {
       this.createTaskService = createTaskService;
       this.getTasksService = getTasksService;
       this.getTaskService = getTaskService;
       this.updateTaskService = updateTaskService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> Test() {
        return ResponseEntity.ok().body("Success!");
    }

    @PostMapping("/task")
    public  ResponseEntity<TaskDTO> createTask(@RequestBody Task task){
       return createTaskService.execute(task);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDTO>> getTasks(){
        return getTasksService.execute(null);
    }

    @GetMapping("/task/{id}")
    public  ResponseEntity<TaskDTO> getTaskById(@PathVariable UUID id){
        return getTaskService.execute(id);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable UUID id, @RequestBody Task task){
       return updateTaskService.execute(new UpdateTaskCommand(id, task));
    }



}
