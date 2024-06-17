package com.easylearn.unir.dao.repository;

import com.easylearn.unir.dao.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> { }
