package com.easylearn.unir.services.implementations;

import com.easylearn.unir.dao.dtos.Response;
import com.easylearn.unir.dao.entity.Teacher;
import com.easylearn.unir.dao.repository.TeacheRepository;
import com.easylearn.unir.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private TeacheRepository teacheRepository;
    @Override
    public Response<Teacher> create(Teacher teacher) {
        return new Response<>(true,teacheRepository.save(teacher));
    }

    @Override
    public Response<Teacher> edit(Teacher teacher) {
        return new Response<>(true,teacheRepository.save(teacher));
    }

    @Override
    public Response<Teacher> listById(Long id) {
        return new Response<>(true,teacheRepository.findById(id).get());
    }

    @Override
    public Response<Teacher> delete(Long id) {
        teacheRepository.deleteById(id);
        return new Response<>(true, "Teacher deleted");
    }
}
