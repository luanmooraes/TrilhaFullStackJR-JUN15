package com.manager.api.controller;

import com.manager.api.domain.project.Project;
import com.manager.api.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> listProjects(){
        return projectService.getAllProjects();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project){
        return projectService.createProject(project);
    }
}
