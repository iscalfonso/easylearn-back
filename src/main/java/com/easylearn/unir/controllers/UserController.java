package com.easylearn.unir.controllers;

import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.User;
import com.easylearn.unir.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping()
    public ResponseDto<User> save(@RequestBody User user){
        return service.save(user);
    }

    @GetMapping("/{id}")
    public ResponseDto<User> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping()
    public ResponseDto<User> edit(@RequestBody User user){
        return service.edit(user);
    }

    @DeleteMapping("/{id}")
    public ResponseDto<User> delete(@PathVariable Long id){
        return service.delete(id);
    }
}
