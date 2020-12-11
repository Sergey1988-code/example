package com.example.epam.service;

import com.example.epam.model.Project;
import com.example.epam.model.User;

import java.util.List;

public interface ProjectService {

    void add(Project project);

    List<Project> getProject();

    void delete(Long id);

    void addUserToProject(User user);

}
