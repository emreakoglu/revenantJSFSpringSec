package com.example.primefaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.model.User;
import com.example.services.UserService;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionInfo {
	
	@Autowired
	private UserService userService;
	
	private User user;


	public User getCurrentUser() {
		if (user == null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			user = userService.findByUsername(authentication.getName());
		}
		
		return user;
	}

}
