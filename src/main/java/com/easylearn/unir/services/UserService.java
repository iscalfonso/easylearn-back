package com.easylearn.unir.services;

import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.User;

public interface UserService {
    ResponseDto<User> save(User user);
    ResponseDto<User> findById(Long id);
    ResponseDto<User> findPhone(String phone);
    ResponseDto<User> edit(User user);
    ResponseDto<User> delete(Long id);
}
