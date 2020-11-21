package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
