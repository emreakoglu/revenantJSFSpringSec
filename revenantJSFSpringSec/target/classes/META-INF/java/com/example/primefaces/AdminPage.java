package com.example.primefaces;

import javax.inject.Inject;
import javax.inject.Named;

import org.omg.CORBA.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.example.model.User;
import com.example.services.UserService;


@Controller(value ="adminPage")
public class AdminPage {
	
	@Autowired
	UserService userService;

	@Autowired
	SessionInfo sessionInfo;
	
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public String findUser() {
		
		User currentUser = sessionInfo.getCurrentUser();
		System.out.println(currentUser.getName());
		this.user = currentUser;
		return currentUser.getName();
	}

}
