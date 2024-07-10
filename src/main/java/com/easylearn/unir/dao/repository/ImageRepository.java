package com.easylearn.unir.dao.repository;

import com.easylearn.unir.dao.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByPost(Long id);
}
