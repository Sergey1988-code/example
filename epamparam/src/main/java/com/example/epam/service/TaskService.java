package com.example.epam.service;

import com.example.epam.model.Task;

import java.util.List;

public interface TaskService {

    public void add(Task task);

    public void closeTask(Long id);

    void assignTask(Long userId, Task task);

    void delete(Long taskId);

    void changeTaskStatus(Long taskId, boolean newStatus);

    List<Task> getReport(Long projectId, Long userId);
}
