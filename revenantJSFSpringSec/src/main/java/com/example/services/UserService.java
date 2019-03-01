package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repositories.UserRepository;


@Service
public class UserService {

	@Autowired
	UserRepository userRepository;


	public User checkUser(String userName, String password) {
		
		User user = null;
		user = userRepository.findByUsernameAndPassword(userName, password);
		
		if (user != null) {
			return user;
		}

		return null;

	}
	
	public User findByUsername (String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}

}
