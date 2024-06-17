package com.easylearn.unir.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "classes")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "subject_id")
    private Long subject;
    @Column(name = "teacher_id")
    private Long teacher;
}
