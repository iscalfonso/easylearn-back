package com.easylearn.unir.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "class_id")
    private Long classId;
    private boolean active;
    private String description;
    private Date creation;
    private Date delivery;
}
