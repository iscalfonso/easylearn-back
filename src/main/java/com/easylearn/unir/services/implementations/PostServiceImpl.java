package com.easylearn.unir.services.implementations;

import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.Post;
import com.easylearn.unir.dao.repository.PostRepositopory;
import com.easylearn.unir.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepositopory repository;
    @Override
    public ResponseDto<Post> save(Post post) {
        return new ResponseDto<>(true, repository.save(post));
    }

    @Override
    public ResponseDto<List<Post>> getByTeacher(Long id) {
        return new ResponseDto<>(true, repository.findByClassId(id));
    }

    @Override
    public ResponseDto<Post> getById(Long id) {
        return new ResponseDto<>(true, repository.findById(id).get());
    }

    @Override
    public ResponseDto<Post> edit(Post post) {
        Post postdb = repository.findById(post.getId()).get();
        postdb.setTitle(post.getTitle());
        postdb.setClassId(post.getClassId());
        postdb.setDescription(post.getDescription());
        postdb.setDelivery(post.getDelivery());
        return new ResponseDto<>(true, repository.save(postdb));
    }

    @Override
    public ResponseDto<Post> disable(Long id) {
        return new ResponseDto<>(true, "The post was disabled");
    }

    @Override
    public ResponseDto<Post> delete(Long id) {
        repository.deleteById(id);
        return new ResponseDto<>(true, "The post was deleted");
    }
}
