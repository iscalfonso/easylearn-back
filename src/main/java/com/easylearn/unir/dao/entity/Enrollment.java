package com.easylearn.unir.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student_id")
    private Long student;
    @Column(name = "class_id")
    private Long classId;
}
