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
public class Project {

    @Id
    @GeneratedValue
    Long id;

    String name;
    String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    List<User> userList;

}
