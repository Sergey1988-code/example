package com.example.epam.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Task {

    @Id
    @GeneratedValue
    Long id;

    LocalDateTime startTime;
    LocalDateTime endTime;

    boolean isActive;

    String topic;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "task_to_user"))
    User user;

    @OneToMany(cascade = CascadeType.ALL)
    List<Task> subtaskList;

}
