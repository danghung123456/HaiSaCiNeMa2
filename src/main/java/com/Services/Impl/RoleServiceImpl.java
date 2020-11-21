package com.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Repository.RoleRepository;
import com.Services.RoleService;
import com.Services.UserService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository repository;

}
