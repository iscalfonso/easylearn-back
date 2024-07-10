package com.easylearn.unir.controllers;

import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.Image;
import com.easylearn.unir.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("images")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService service;

    @PostMapping
    public ResponseDto<Image> save(@RequestBody Image image){
        return service.save(image);
    }

    @GetMapping("/{id}")
    public ResponseDto<List<Image>> getAll(@PathVariable Long id){
        return service.getAll(id);
    }

    @DeleteMapping("/{id}")
    public ResponseDto<Image> delete(Long id){
        return service.delete(id);
    }
}
