package com.example.epam.controller;

import com.example.epam.model.Project;
import com.example.epam.model.User;
import com.example.epam.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/project")
public class ProjectController {

    ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping(path = "/assign")
    public void assignUser(@RequestBody User user) {
        projectService.addUserToProject(user);
    }

    @DeleteMapping(path = "/delete")
    public void delete(@RequestParam Long projectId) {
        projectService.delete(projectId);
    }

    @PutMapping(path = "/update")
    public void update(@RequestBody Project project) {
        projectService.add(project);
    }

    @PostMapping(path = "/add")
    public void add(@RequestBody Project project) {
        projectService.add(project);
    }

    @GetMapping(path = "/get")
    public List<Project> get() {
       return projectService.getProject();
    }


}
