package com.easylearn.unir.services;

import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.Subject;

import java.util.List;

public interface SubjectService {
//    ResponseDto<List<Subject>> getByTeacher(Long id);
    ResponseDto<Subject> getById(Long id);
}
