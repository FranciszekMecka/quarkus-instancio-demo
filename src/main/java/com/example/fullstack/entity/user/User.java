package com.example.fullstack.entity.user;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    String password;

    @Version
    public int version;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private ZonedDateTime created;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "id"))
    public List<String> roles;

}
