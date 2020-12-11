package com.example.epam.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue
    Long id;

    String name;

    @ManyToOne
    @JoinColumn(name = "project_id", foreignKey = @ForeignKey(name = "user_to_project"))
    Project project;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    List<Task> taskList;

}
