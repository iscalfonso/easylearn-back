package com.easylearn.unir.services;

import com.easylearn.unir.dao.dtos.Response;
import com.easylearn.unir.dao.entity.Teacher;

public interface TeacherService {
    Response<Teacher> create(Teacher teacher);
    Response<Teacher> edit(Teacher teacher);
    Response<Teacher> listById(Long id);
    Response<Teacher> delete(Long id);
}
