package com.easylearn.unir.dao.repository;

import com.easylearn.unir.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhone(String username);
}
