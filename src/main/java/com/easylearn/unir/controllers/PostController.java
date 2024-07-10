package com.easylearn.unir.controllers;

import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.Post;
import com.easylearn.unir.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService service;

    @PostMapping
    public ResponseDto<Post> save(@RequestBody Post post){
        return service.save(post);
    }

    @GetMapping("teachers/{id}")
    public ResponseDto<List<Post>> getByTeacher(@PathVariable Long id){
        return service.getByTeacher(id);
    }

    @GetMapping("students/{id}")
    public ResponseDto<List<Post>> getByStudent(@PathVariable Long id){
        return service.getByStudent(id);
    }

    @GetMapping("/{id}")
    public ResponseDto<Post> getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping()
    public ResponseDto<Post> edit(@RequestBody Post post){
        return service.edit(post);
    }

    @PutMapping("/{id}")
    public ResponseDto<Post> disable(@PathVariable Long id){
        return service.disable(id);
    }

    @DeleteMapping("/{id}")
    public ResponseDto<Post> delete(@PathVariable Long id){
        return service.delete(id);
    }
}
