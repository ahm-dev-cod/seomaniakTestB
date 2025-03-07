package com.example.seomaniaktest.controllers;
import com.example.seomaniaktest.dto.TaskDTO;
import com.example.seomaniaktest.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
@AllArgsConstructor
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> taskDTOS = taskService.getTasks();
        return new ResponseEntity<>(taskDTOS, HttpStatus.OK);
    }
    // ###################################################################################
    @GetMapping("/search")
    public List<TaskDTO> searchTasks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String status) {
        return taskService.searchTasks(title, status);
    }
}
