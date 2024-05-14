package com.easylearn.unir.dao.repository;

import com.easylearn.unir.dao.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacheRepository extends JpaRepository<Teacher, Long> {
}
