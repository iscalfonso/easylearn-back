package com.easylearn.unir.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String password;
    @Column(name = "role_id")
    private Long role;
}
