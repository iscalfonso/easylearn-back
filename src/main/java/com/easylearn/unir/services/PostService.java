package com.easylearn.unir.services;

import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.Post;

import java.util.List;

public interface PostService {
    ResponseDto<Post> save(Post post);
    ResponseDto<List<Post>> getByTeacher(Long id);
    ResponseDto<Post> getById(Long id);
    ResponseDto<Post> edit(Post post);
    ResponseDto<Post> disable(Long id);
    ResponseDto<Post> delete(Long id);
}
