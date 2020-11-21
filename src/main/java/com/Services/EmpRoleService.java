package com.Services;

import org.springframework.stereotype.Service;

import com.Entity.EmpRole;

@Service
public interface EmpRoleService {
	EmpRole add(EmpRole empRole);
}
