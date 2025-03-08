package com.example.seomaniaktest.controllers;
import com.example.seomaniaktest.dto.TaskDTO;
import com.example.seomaniaktest.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
@CrossOrigin(origins = "http://localhost:4200") // Autorise Angular
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
    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO taskDTO1 = taskService.addTask(taskDTO);
        return new ResponseEntity<>(taskDTO1, HttpStatus.CREATED);
    }
    // ###################################################################################

    @GetMapping("/search")
    public List<TaskDTO> searchTasks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String status) {
        return taskService.searchTasks(title, status);
    }
    // ###################################################################################
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>("Task deleted", HttpStatus.OK);
    }

  //  @PatchMapping("{id}")
  //  public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
   //     taskDTO.setId(id);
    //    TaskDTO taskDTO1 = taskService.updateTask(taskDTO);
     //   return new ResponseEntity<>(taskDTO1, HttpStatus.OK);
   // }
}
