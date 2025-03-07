package com.example.seomaniaktest.services;

import com.example.seomaniaktest.dao.ProjectRepository;
import com.example.seomaniaktest.dto.ProjectDTO;
import com.example.seomaniaktest.entities.Project;
import com.example.seomaniaktest.entities.Task;
import com.example.seomaniaktest.map.ProjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ProjectServiceImp implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    // ###################################################################################
    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projectSet = projectRepository.findAll();
        return projectSet.stream()
                .map(ProjectMapper::mapToProjectDTO)
                .collect(Collectors.toList());
    }
    // ###################################################################################
    @Override
    public ProjectDTO addProject(ProjectDTO projectDTO) {
        Project project = ProjectMapper.mapToProject(projectDTO);
        project = projectRepository.save(project);
        return ProjectMapper.mapToProjectDTO(project);
    }
    // ###################################################################################
    @Override
    public ProjectDTO updateProjectById(ProjectDTO projectDTO) {
        Optional<Project> projectOptional = projectRepository.findById(projectDTO.getId());
        if (projectOptional.isPresent()) {
            Project projectToUpdate = projectOptional.get();
            updateProjectEntityFromDTO(projectToUpdate, projectDTO);
            projectRepository.save(projectToUpdate);
            return ProjectMapper.mapToProjectDTO(projectToUpdate);
        }
        return null;
    }
    static DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
    // 2023-12-25
    private void updateProjectEntityFromDTO(Project projectToUpdate, ProjectDTO projectDTO) {
        projectToUpdate.setName(projectDTO.getName());
        projectToUpdate.setDescription(projectDTO.getDescription());
        projectToUpdate.setStartDate(LocalDate.parse(projectDTO.getStartDate(), formatter));
        projectToUpdate.setEndDate(LocalDate.parse(projectDTO.getEndDate(), formatter));
    }
    // ###################################################################################
    @Override
    public void deleteProjectById(Long id) {
        if (projectRepository.findById(id).isPresent()) {
            projectRepository.deleteById(id);
        }
    }
    // ###################################################################################
    @Override
    public List<Task> getTasksByProjectId(Long projectId) {
        return projectRepository
                .findWithTasksById(projectId)
                .map(Project::getTasks)
                .orElse(Collections.emptyList());
    }
    // ###################################################################################


}
// ###################################################################################
