package com.example.Capstone.task.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    IN_PROGRESS("In Progress"),
    FINISHED("Finished"),
    NOT_STARTED("Not Started");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    @JsonValue
    public String getStatus(){
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
