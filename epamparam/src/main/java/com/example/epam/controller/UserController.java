package com.example.epam.controller;

import com.example.epam.model.User;
import com.example.epam.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {


    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/add")
    public void add(@RequestBody User user) {
        userService.add(user);
    }

    @PutMapping(path = "/update")
    public void update(@RequestBody User user) {
        userService.add(user);
    }

    @GetMapping(path = "/getByProject")
    public List<User> getUserByProject(@RequestParam Long id) {
        return userService.getUsersByProjectId(id);
    }

    @DeleteMapping(path = "/delete")
    public void delete(@RequestParam Long id) {
        userService.delete(id);
    }


}
