package com.example.epam.controller;

import com.example.epam.model.Task;
import com.example.epam.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/task")
public class TaskController {

    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(path = "/assign")
    public void assignTask(@RequestParam Long userId, @RequestBody Task task) {
        taskService.assignTask(userId, task);
    }

    @DeleteMapping(path = "/delete")
    public void delete(@RequestParam Long taskId) {
        taskService.delete(taskId);
    }

    @PutMapping(path = "/changeStatus")
    public void changeTaskStatus(@RequestParam Long taskId, @RequestParam boolean newStatus) {
        taskService.changeTaskStatus(taskId, newStatus);
    }

    @PutMapping(path = "/update")
    public void updateTask(@RequestBody Task task) {
        taskService.add(task);
    }

    @GetMapping(path = "/report")
    public List<Task> getReport(@RequestParam Long projectId, @RequestParam Long userId) {
        return taskService.getReport(projectId, userId);
    }

}
