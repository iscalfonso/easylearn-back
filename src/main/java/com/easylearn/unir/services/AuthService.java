package com.easylearn.unir.services;

import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {
    ResponseDto<String> register(User user);
    User authenticate(User user);
    UserDetails loadUser(String username);

}
