package com.example.seomaniaktest.dao;

import com.example.seomaniaktest.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
