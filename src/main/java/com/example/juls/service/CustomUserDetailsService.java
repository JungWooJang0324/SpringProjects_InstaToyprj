package com.example.juls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.juls.model.Users;
import com.example.juls.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users users = userRepository.findByUsername(username);
		CustomUserDetails userDetails = null;
		
		if(users != null) {
			userDetails = new CustomUserDetails();
			userDetails.setUsers(users);
			
		}else {
			throw new UsernameNotFoundException("Cannot find user. / 유저를 찾을 수 없습니다. ");
		}
		
		return userDetails;
	}

}
