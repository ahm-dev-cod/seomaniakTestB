package com.example.seomaniaktest.services;

import com.example.seomaniaktest.dto.ProjectDTO;
import com.example.seomaniaktest.entities.Task;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> getAllProjects();
    ProjectDTO addProject(ProjectDTO projectDTO);
//    ProjectDTO getProjectById(Long id);
    ProjectDTO updateProjectById(ProjectDTO projectDTO);
    void deleteProjectById(Long id);
    List<Task> getTasksByProjectId(Long projectId);
}
