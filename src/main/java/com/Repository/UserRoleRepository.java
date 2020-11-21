package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}
