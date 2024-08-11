package com.easylearn.unir.services.implementations;

import com.easylearn.unir.dao.dtos.CustomUserDetails;
import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.User;
import com.easylearn.unir.dao.repository.UserRepository;
import com.easylearn.unir.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;
    @Override
    public ResponseDto<String> register(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User newUser = new User();
        newUser.setPhone(user.getPhone());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setName(user.getName());
        newUser.setRole(user.getRole());
        repository.save(newUser);
        return new ResponseDto<>(true, "User created");
    }

    @Override
    public User authenticate(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User userdata = repository.findByPhone(user.getPhone());
        if (userdata != null && passwordEncoder.matches(user.getPassword(), userdata.getPassword())) {
            return userdata;
        }
        return null;
    }

    @Override
    public UserDetails loadUser(String phone) {
        User user = repository.findByPhone(phone);
        if(user == null)
            throw new UsernameNotFoundException("Usuario no encontrado..!!");
        return new CustomUserDetails(user);
    }

}
