package com.runtime.hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_data", schema = "todolist", catalog = "hiberlesson")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false, length = -1)
    private String email;

    @Column(name = "userpassword", nullable = false, length = -1)
    private String password;

    @Column(name = "username", nullable = false, length = -1)
    private String username;
}