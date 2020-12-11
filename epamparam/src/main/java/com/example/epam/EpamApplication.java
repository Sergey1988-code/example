package com.example.epam;

import com.example.epam.model.Project;
import com.example.epam.model.User;
import com.example.epam.repository.TaskRepository;
import com.example.epam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EpamApplication {

    public static void main(String[] args) {
        SpringApplication.run(EpamApplication.class, args);

    }
}
