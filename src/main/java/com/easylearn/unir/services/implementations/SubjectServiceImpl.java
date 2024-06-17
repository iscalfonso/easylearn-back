package com.easylearn.unir.services.implementations;

import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.Subject;
import com.easylearn.unir.dao.repository.SubjectRepository;
import com.easylearn.unir.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository repository;
    /*@Override
    public ResponseDto<List<Subject>> getByTeacher(Long id) {
        return new ResponseDto<>(true, repository.findByUser(id));
    }*/

    @Override
    public ResponseDto<Subject> getById(Long id) {
        return new ResponseDto<>(true, repository.findById(id).get());
    }
}
