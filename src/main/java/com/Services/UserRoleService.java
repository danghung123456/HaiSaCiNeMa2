package com.Services;

import org.springframework.stereotype.Service;

import com.Entity.Role;
import com.Entity.UserRole;

@Service
public interface UserRoleService {
	
	UserRole add(UserRole userRole);
	
	void deleteByUserId(Integer id);
	

}
