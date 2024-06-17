package com.easylearn.unir.dao.repository;

import com.easylearn.unir.dao.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepositopory extends JpaRepository<Post, Long> {
    List<Post> findByClassId(Long id);
}
