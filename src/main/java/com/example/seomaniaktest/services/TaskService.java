package com.example.seomaniaktest.services;

import com.example.seomaniaktest.dto.TaskDTO;
import com.example.seomaniaktest.entities.Task;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getTasks();
    List<Task> getTasksByProjectId(Long projectId);
    List<TaskDTO> searchTasks(String title, String status);
    TaskDTO addTask(TaskDTO taskDTO);
    void deleteTask(Long taskId);
   // TaskDTO updateTask(TaskDTO taskDTO);
}
