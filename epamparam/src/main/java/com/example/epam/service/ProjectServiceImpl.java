package com.example.epam.service;

import com.example.epam.model.Project;
import com.example.epam.model.User;
import com.example.epam.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;


    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public void add(Project project) {
        projectRepository.save(project);
    }

    @Override
    public List<Project> getProject() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public void addUserToProject(User user) {
        Long id = user.getProject().getId();
        Project project = projectRepository.findById(id).get();
        List<User> userList = project.getUserList();
        userList.add(user);
        project.setUserList(userList);
        projectRepository.save(project);

    }
}
