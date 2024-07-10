package com.easylearn.unir.services;
import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.Image;

import java.util.List;

public interface ImageService {
    ResponseDto<Image> save(Image image);
    ResponseDto<List<Image>> getAll(Long id);
    ResponseDto<Image> delete(Long id);
}
