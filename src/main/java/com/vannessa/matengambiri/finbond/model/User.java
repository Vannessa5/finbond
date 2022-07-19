package com.vannessa.matengambiri.finbond.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Getter
@Setter

@Entity
@Table(name = "users")
public class User extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String username;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> authorities = new ArrayList<>();
    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "user_locked")
    private Boolean userLocked;

    public User() {
    }
}
