package com.example.Capstone.task;

import com.example.Capstone.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    // SELECT * FROM task WHERE category_id = :categoryId
    List<Task> findAllByCategoryId(UUID categoryId);
}
