package com.example.fullstack.entity.task;

import com.example.fullstack.entity.project.Project;
import com.example.fullstack.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    public String title;

    @Column(length = 1000)
    public String description;

    public Integer priority;

    @ManyToOne(optional = false)
    public User user;

    public ZonedDateTime complete;

    @ManyToOne
    public Project project;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    public ZonedDateTime created;

    @Version
    public int version;
}