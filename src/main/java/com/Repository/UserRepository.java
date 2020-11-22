package com.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.Entity.User;
import com.Entity.Users;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	Optional<User> findByEmail(String email);

}
