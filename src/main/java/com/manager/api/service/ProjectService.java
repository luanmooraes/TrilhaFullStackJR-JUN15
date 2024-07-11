package com.manager.api.service;

import com.manager.api.domain.project.Project;
import com.manager.api.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public Project createProject(Project project){
        return projectRepository.save(project);
    }

    public Project updateProject(String projectId, Project project){
        Project foundProject = projectRepository.findById(projectId).orElse(null);
        if (foundProject != null) {
            foundProject.setTitle(project.getTitle());
            foundProject.setDescription(project.getDescription());
            return projectRepository.save(foundProject);
        }
        return null;
    }

    public void deleteProject(String projectId){
        projectRepository.deleteById(projectId);
    }
}
