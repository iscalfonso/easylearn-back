package com.easylearn.unir.controllers;

import com.easylearn.unir.services.JwtUtil;
import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.User;
import com.easylearn.unir.services.AuthService;
import com.easylearn.unir.services.implementations.JwtUtilImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseDto<String> login(@RequestBody User user) {
        JwtUtilImpl jwtUtil = new JwtUtilImpl();
        System.out.println(user.toString());
        User userAuth = authService.authenticate(user);
        if (userAuth != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("name", userAuth.getName());
            claims.put("role", userAuth.getRole().getName());
            String token = jwtUtil.generateToken(userAuth.getPhone(), claims);

            return new ResponseDto<>(true, token);
        }
        throw new RuntimeException("Credenciales inválidas");
    }

    @PostMapping("/register")
    public ResponseDto<String> register(@RequestBody User user) {
        return authService.register(user);
    }

    @GetMapping
    public ResponseDto<String> probar() {
        return new ResponseDto<>(true, "Ruta accedida");
    }
}
