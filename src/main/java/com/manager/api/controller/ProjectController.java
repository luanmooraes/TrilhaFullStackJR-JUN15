package com.manager.api.controller;

import com.manager.api.domain.project.Project;
import com.manager.api.service.ProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    ProjectService projectService;

    @GetMapping
    public List<Project> listProjects(){
        return projectService.getAllProjects();
    }
}
