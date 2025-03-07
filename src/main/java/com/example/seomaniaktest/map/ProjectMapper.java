package com.example.seomaniaktest.map;

import com.example.seomaniaktest.dto.ProjectDTO;
import com.example.seomaniaktest.entities.Project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProjectMapper {
    static DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    // Exemple : 2023-10-05
    public static ProjectDTO mapToProjectDTO(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setDescription(project.getDescription());
        if (project.getStartDate() != null) {
            projectDTO.setStartDate(project.getStartDate().format(formatter));
        }
        if (project.getEndDate() != null) {
            projectDTO.setEndDate(project.getEndDate().format(formatter));
        }
        return projectDTO;
    }

    public static Project mapToProject(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setId(projectDTO.getId());
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setStartDate(LocalDate.parse(projectDTO.getStartDate(), formatter));
        project.setEndDate(LocalDate.parse(projectDTO.getEndDate(), formatter));
        return project;
    }
}
