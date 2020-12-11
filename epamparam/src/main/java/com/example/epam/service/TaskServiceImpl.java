package com.example.epam.service;

import com.example.epam.model.Project;
import com.example.epam.model.Task;
import com.example.epam.model.User;
import com.example.epam.repository.ProjectRepository;
import com.example.epam.repository.TaskRepository;
import com.example.epam.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public void add(Task task) {
        task.setStartTime(LocalDateTime.now());
        task.setActive(true);
        taskRepository.save(task);
    }

    @Override
    public void closeTask(Long id) {
        Task task = taskRepository.findById(id).get();
        task.setEndTime(LocalDateTime.now());
        task.setActive(false);
    }

    @Override
    public void assignTask(Long userId, Task task) {
        User user = userRepository.findById(userId).get();
        task.setActive(true);
        task.setStartTime(LocalDateTime.now());
        List<Task> taskList = user.getTaskList();
        taskList.add(task);
        userRepository.save(user);
    }

    @Override
    public void delete(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public void changeTaskStatus(Long taskId, boolean newStatus) {
        Task task = taskRepository.findById(taskId).get();
        task.setActive(newStatus);
        taskRepository.save(task);
    }

    @Override
    public List<Task> getReport(Long projectId, Long userId) {
        Project project = projectRepository.findById(projectId).get();
        List<User> userList = project.getUserList();
        User user = null;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(userId)) {
                user = userList.get(i);
            }
        }
        return user.getTaskList();
    }

    public LocalDateTime getTimeForTask(Long id) {
        Task task = taskRepository.findById(id).get();
        return task.getStartTime();

    }
}
