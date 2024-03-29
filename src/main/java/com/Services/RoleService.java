package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Entity.Role;

@Service
public interface RoleService {

	Role findById(Integer id);

	List<Role> getAll();
}
