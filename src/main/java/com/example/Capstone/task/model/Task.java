package com.example.Capstone.task.model;

import com.example.Capstone.category.model.Category;
import com.example.Capstone.uuidGeneratorV7.GeneratedUuidV7;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Task {
    @Id
    @GeneratedUuidV7
    private UUID id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "Time_spent")
    private Integer time_spent;

    @Column(name = "Time_intended")
    private Integer time_intended;

    @Column(name = "name")
    private String name;

    @Column(name = "start_schedule")
    private Integer start_schedule;

    @Column(name = "end_schedule")
    private Integer end_schedule;

    @Column(name = "breaks")
    private Integer breaks;

    @Column(name = "Longest_work_stretch")
    private Integer longest_work_stretch;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "description")
    private String description;

    @Column(name = "in_focus_list")
    private Boolean in_focus_list;

    @Column(name = "is_selected")
    private Boolean is_selected;
}
