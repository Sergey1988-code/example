package com.example.epam.service;

import com.example.epam.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> getUsers();

    void delete(Long id);

    List<User> getUsersByProjectId(Long id);
}
