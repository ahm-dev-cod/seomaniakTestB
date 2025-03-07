package com.example.seomaniaktest.services;

import com.example.seomaniaktest.dao.TaskRepository;
import com.example.seomaniaktest.dto.TaskDTO;
import com.example.seomaniaktest.entities.Task;
import com.example.seomaniaktest.map.TaskMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class TaskServiceImp implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    // ###################################################################################
    @Override
    public List<TaskDTO> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(TaskMapper::mapToTaskDTO)
                .collect(Collectors.toList());
    }
    // ###################################################################################
    @Override
    public List<Task> getTasksByProjectId(Long projectId) {
        return taskRepository.findByProject_Id(projectId);
    }
    // ###################################################################################
    @Override
    public List<TaskDTO> searchTasks(String title, String status) {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .filter(task -> (title == null || task.getTitle().contains(title)))
                .filter(task -> (status == null || task.getStatus().equals(status)))
                .map(TaskMapper::mapToTaskDTO)
                .collect(Collectors.toList());
    }
    // ###################################################################################

}
