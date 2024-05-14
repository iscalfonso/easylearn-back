package com.easylearn.unir.controllers;

import com.easylearn.unir.dao.dtos.Response;
import com.easylearn.unir.dao.entity.Teacher;
import com.easylearn.unir.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TeacherController {
    private TeacherService teacherService;

    @PostMapping
    public Response<Teacher> create(@RequestBody Teacher teacher){
        return teacherService.create(teacher);
    }
    @GetMapping("/{id}")
    public Response<Teacher> getById(@PathVariable Long id){
        return teacherService.listById(id);
    }
    @PutMapping
    public Response<Teacher> edit(@RequestBody Teacher teacher){
        return teacherService.edit(teacher);
    }
    @DeleteMapping("/{id}")
    public Response<Teacher> delete(@PathVariable Long id){
        return teacherService.delete(id);
    }
}
