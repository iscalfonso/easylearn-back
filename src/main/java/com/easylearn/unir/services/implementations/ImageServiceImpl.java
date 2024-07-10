package com.easylearn.unir.services.implementations;

import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.Image;
import com.easylearn.unir.dao.repository.ImageRepository;
import com.easylearn.unir.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository repository;
    @Override
    public ResponseDto<Image> save(Image image) {
        return new ResponseDto<>(true, repository.save(image));
    }

    @Override
    public ResponseDto<List<Image>> getAll(Long id) {
        return new ResponseDto(true, repository.findByPost(id));
    }

    @Override
    public ResponseDto<Image> delete(Long id) {
        repository.deleteById(id);
        return new ResponseDto<>(true, "Image deleted");
    }
}
