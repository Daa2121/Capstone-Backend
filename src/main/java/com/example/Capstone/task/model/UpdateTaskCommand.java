package com.example.Capstone.task.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UpdateTaskCommand {
    private UUID id;
    private Task task;

    public UpdateTaskCommand(UUID id, Task task) {
        this.id = id;
        this.task = task;
    }
}
