package com.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Entity.Users;
import com.Repository.UserRepository;
import com.Services.Impl.UserDetailImpl;

@Service
public class UserDetailServiceCustom implements UserDetailsService {

	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Users> user = repo.findByUserName(username);
		user.orElseThrow(() -> new UsernameNotFoundException("user not found: " + username));
		return user.map(UserDetailImpl::new).get();
	}

}
