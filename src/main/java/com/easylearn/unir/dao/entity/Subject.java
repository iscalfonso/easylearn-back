package com.easylearn.unir.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String grade;
}
