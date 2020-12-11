package com.example.epam.repository;

import com.example.epam.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends CrudRepository<Task,Long> {

}
