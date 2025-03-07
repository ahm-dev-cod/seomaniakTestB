package com.example.seomaniaktest.controllers;

import com.example.seomaniaktest.dto.ProjectDTO;
import com.example.seomaniaktest.entities.Task;
import com.example.seomaniaktest.services.ProjectService;
import com.example.seomaniaktest.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/projects")
@AllArgsConstructor
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    // ###################################################################################
    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<ProjectDTO> projectDTOS = projectService.getAllProjects();
        return new ResponseEntity<>(projectDTOS, HttpStatus.OK);
    }
    // ###################################################################################
    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO) {
        ProjectDTO projectDTO1 = projectService.addProject(projectDTO);
        return new ResponseEntity<>(projectDTO1, HttpStatus.CREATED);
    }
    // ###################################################################################
    @PatchMapping("{id}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable("id") Long id, @RequestBody ProjectDTO projectDTO) {
        projectDTO.setId(id);
        ProjectDTO projectDTO1 = projectService.updateProjectById(projectDTO);
        return new ResponseEntity<>(projectDTO1, HttpStatus.OK);
    }
    // ###################################################################################
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProjectById(id);
        return new ResponseEntity<>("Project deleted", HttpStatus.OK);
    }
    // ###################################################################################
    @Autowired
    private TaskService taskService;
    @GetMapping("/{projectId}/tasks")
    public ResponseEntity<List<Task>> getTasksByProject(@PathVariable Long projectId) {
        List<Task> tasks = taskService.getTasksByProjectId(projectId);
        return ResponseEntity.ok(tasks);
    }

}
// ###################################################################################