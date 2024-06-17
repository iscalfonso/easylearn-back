package com.easylearn.unir.dao.repository;

import com.easylearn.unir.dao.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Query(value = "SELECT s.id, s.name, s.grade FROM classes c JOIN  subjects s ON c.subject_id = s.id where c.teacher_id = ?", nativeQuery = true)
    List<Subject> findByTeacher(Long id);
}
