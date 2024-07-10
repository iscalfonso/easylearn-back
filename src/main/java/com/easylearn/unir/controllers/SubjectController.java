package com.easylearn.unir.controllers;

import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.Subject;
import com.easylearn.unir.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService service;

    @GetMapping("teachers/{id}")
    public ResponseDto<List<Subject>> getByTeacher(@PathVariable Long id){
        return service.getByTeacher(id);
    }

    @GetMapping("/{id}")
    public ResponseDto<Subject> getById(@PathVariable Long id){
        return service.getById(id);
    }

}
