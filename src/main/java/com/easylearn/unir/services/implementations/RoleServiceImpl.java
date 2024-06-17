package com.easylearn.unir.services.implementations;

import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.Role;
import com.easylearn.unir.dao.repository.RolRepository;
import com.easylearn.unir.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RolRepository repository;
    @Override
    public ResponseDto<List<Role>> getAll() {
        return new ResponseDto<>(true, repository.findAll());
    }
}
