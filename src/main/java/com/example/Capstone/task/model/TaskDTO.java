package com.example.Capstone.task.model;

import lombok.Data;

import java.util.UUID;

@Data
public class TaskDTO {
    private UUID id;
    private Status status;
    private Integer time_spent;
    private Integer time_intended;
    private String name;
    private Integer start_schedule;
    private Integer end_schedule;
    private Integer breaks;
    private Integer longest_work_stretch;
    private String description;
    private Boolean in_focus_list;
    private Boolean is_selected;

    public TaskDTO(Task task) {
        this.is_selected = task.getIs_selected();
        this.in_focus_list = getIn_focus_list();
        this.description = task.getDescription();
        this.longest_work_stretch = task.getLongest_work_stretch();
        this.breaks = task.getBreaks();
        this.end_schedule = task.getEnd_schedule();
        this.start_schedule = task.getStart_schedule();
        this.name = task.getName();
        this.time_intended = task.getTime_intended();
        this.time_spent = task.getTime_spent();
        this.status = task.getStatus();
        this.id = task.getId();
    }
}
