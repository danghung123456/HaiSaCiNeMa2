package com.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	@Query("from Users u where u.username = :username")
	Optional<Users> findByUserName(String username);
}
