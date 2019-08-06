package com.sourcebits.eventHandling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sourcebits.eventHandling.model.User;
import com.sourcebits.eventHandling.repository.UserRepository;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		
		CustomUserDetails customUserDetails = null;
		if (null != user) {
			System.out.println(user.getRoles());
			customUserDetails = new CustomUserDetails();
			customUserDetails.setUser(user);
			return customUserDetails;
		} else {
			throw new UsernameNotFoundException("User Not available");
		}

	}

}