package com.example.juls.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.juls.model.Follow;
import com.example.juls.model.Users;
import com.example.juls.repository.FollowRepository;
import com.example.juls.repository.UserRepository;
import com.example.juls.service.CustomUserDetails;

@Controller
public class FollowController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FollowRepository followRepository;
	
	@GetMapping("/follow/{id}")
	public @ResponseBody Follow follow(
			@AuthenticationPrincipal CustomUserDetails userDetail,
			@PathVariable int id
			) {
		Users fromUser = userDetail.getUsers();
		Optional<Users> oToUser = 
				userRepository.findById(id);
		Users toUser = oToUser.get();
		
		Follow follow = new Follow();
		follow.setFromUser(fromUser);
		follow.setToUser(toUser);
		
		followRepository.save(follow);
		
		return follow;
		
	}
	
}
