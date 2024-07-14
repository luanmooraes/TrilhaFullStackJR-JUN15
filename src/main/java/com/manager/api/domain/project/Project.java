package com.manager.api.domain.project;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "projects")
@Table(name = "projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String description;
    private LocalDate startDate;

    // Constructor para fazer uso do DTO
    public Project(RequestProjectDTO requestProjectDTO){
        this.title = requestProjectDTO.title();
        this.description = requestProjectDTO.description();
        this.startDate = requestProjectDTO.startDate();
    }
}
