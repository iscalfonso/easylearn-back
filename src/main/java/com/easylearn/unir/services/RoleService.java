package com.easylearn.unir.services;

import com.easylearn.unir.dao.dtos.ResponseDto;
import com.easylearn.unir.dao.entity.Role;

import java.util.List;

public interface RoleService {
    ResponseDto<List<Role>> getAll();
}
