package com.example.epam.service;

import com.example.epam.model.Project;
import com.example.epam.model.User;
import com.example.epam.repository.ProjectRepository;
import com.example.epam.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public UserServiceImpl(UserRepository userRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsersByProjectId(Long id) {
        Optional<Project> byId = projectRepository.findById(id);
        Project project = null;
        if (byId.isPresent()) {
            project = byId.get();
        }
        return project.getUserList();
    }
}
