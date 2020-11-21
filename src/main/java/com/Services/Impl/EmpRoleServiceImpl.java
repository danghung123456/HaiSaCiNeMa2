package com.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.EmpRole;
import com.Repository.EmpRoleRepository;
import com.Services.EmpRoleService;

@Service
public class EmpRoleServiceImpl implements EmpRoleService {
	@Autowired
	EmpRoleRepository empRoleRepository;

	@Override
	public EmpRole add(EmpRole empRole) {
		return empRoleRepository.save(empRole);
	}
	
	
}
