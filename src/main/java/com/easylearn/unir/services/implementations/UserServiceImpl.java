package com.easylearn.unir.services.implementations;

import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.Role;
import com.easylearn.unir.dao.entity.User;
import com.easylearn.unir.dao.repository.RolRepository;
import com.easylearn.unir.dao.repository.UserRepository;
import com.easylearn.unir.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository repository;
    private final RolRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User register(String username, String password) {
        User user = new User();
        user.setName(username);
        user.setPassword(passwordEncoder.encode(password));
        return repository.save(user);
    }

    @Override
    public ResponseDto<User> save(User user) {
        Role role = roleRepository.findById(user.getRole().getId()).orElseThrow(() -> new RuntimeException("Role not found"));
        //user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(role);
        repository.save(user);
        return new ResponseDto<>(true, repository.save(user));
    }

    @Override
    public ResponseDto<User> findById(Long id) {
        return new ResponseDto<>(true, repository.findById(id).get());
    }

    @Override
    public ResponseDto<User> findPhone(String phone) {
        return new ResponseDto<>(true, repository.findByPhone(phone));
    }

    @Override
    public ResponseDto<User> edit(User user) {
        User userdata = repository.findById(user.getId()).get();
        userdata.setName(user.getName());
        userdata.setPhone(user.getPhone());
        userdata.setPassword(user.getPassword());
        return new ResponseDto<>(true, repository.save(userdata));
    }

    @Override
    public ResponseDto<User> delete(Long id) {
        repository.deleteById(id);
        return new ResponseDto<>(true, "User was Deleted");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
