package com.easylearn.unir.services.implementations;

import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.User;
import com.easylearn.unir.dao.repository.UserRepository;
import com.easylearn.unir.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public ResponseDto<User> save(User user) {
        return new ResponseDto<>(true, repository.save(user));
    }

    @Override
    public ResponseDto<User> findById(Long id) {
        return new ResponseDto<>(true, repository.findById(id).get());
    }

    @Override
    public ResponseDto<User> edit(User user) {
        User userdb = repository.findById(user.getId()).get();
        userdb.setName(user.getName());
        userdb.setPhone(user.getPhone());
        userdb.setPassword(user.getPassword());
        return new ResponseDto<>(true, repository.save(userdb));
    }

    @Override
    public ResponseDto<User> delete(Long id) {
        repository.deleteById(id);
        return new ResponseDto<>(true, "User was Deleted");
    }
}
