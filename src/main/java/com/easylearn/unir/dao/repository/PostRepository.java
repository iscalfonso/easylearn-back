package com.easylearn.unir.dao.repository;

import com.easylearn.unir.dao.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT p.id, p.title, p.active, p.description, p.creation, p.delivery, p.class_id FROM posts p " +
            "JOIN classes c ON p.class_id = c.id where c.teacher_id = ?", nativeQuery = true)
    List<Post> findByTeacher(Long id);
    @Query(value = "SELECT p.id, p.title, p.active, p.description, p.creation, p.delivery, p.class_id FROM posts p " +
            "JOIN enrollments e ON p.class_id = e.class_id WHERE student_id= ?", nativeQuery = true)
    List<Post> findByStudent(Long id);
}
