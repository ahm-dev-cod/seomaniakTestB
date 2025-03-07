package com.example.seomaniaktest.dao;

import com.example.seomaniaktest.entities.Project;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @EntityGraph(attributePaths = {"tasks"})
    Optional<Project> findWithTasksById(Long id);

}
