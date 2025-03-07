package com.example.seomaniaktest.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class TaskDTO {
    private Long id;

    private String title;

    private String description;

    private String status;

    private String dueDate;

    private ProjectDTO projectDTO;
}