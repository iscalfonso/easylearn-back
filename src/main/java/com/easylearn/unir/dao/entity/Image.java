package com.easylearn.unir.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private byte[] image;
    @Column(name = "post_id")
    private Long post;
}
