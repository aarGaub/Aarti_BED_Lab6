package com.debate.registration.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.debate.registration.students.dao.UserRepository;
import com.debate.registration.students.entity.User;
import com.debate.registration.students.security.MyUserDetails;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.getUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found!!");
		}
		return new MyUserDetails(user);
	}

}
