package com.example.seomaniaktest.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ProjectDTO {
    private Long id;

    private String name;

    private String description;

    private String startDate;

    private String endDate;

    private List<TaskDTO> tasks;
}
