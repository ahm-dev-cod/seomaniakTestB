package com.example.seomaniaktest.dao;

import com.example.seomaniaktest.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
