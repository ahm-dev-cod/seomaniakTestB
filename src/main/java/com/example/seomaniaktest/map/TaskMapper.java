package com.example.seomaniaktest.map;

import com.example.seomaniaktest.dto.TaskDTO;
import com.example.seomaniaktest.entities.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskMapper {
    static DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    public static TaskDTO mapToTaskDTO(Task task) {
        if (task == null) {
            return null;
        }
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setDueDate(task.getDueDate().format(formatter));
        return taskDTO;
    }
    public static Task mapToTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        if (taskDTO.getDueDate() != null) {
            task.setDueDate(LocalDate.parse(taskDTO.getDueDate(), formatter));
        }
        return task;
    }
}