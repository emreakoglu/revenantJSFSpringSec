package com.example.primefaces;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.example.model.User;
import com.example.services.UserService;

@Controller(value = "helloWorld")
public class HelloWorld {
	
	private String firstName = "";
	private String lastName = "";

	@Autowired
	UserService userService;
	
	@Inject
	SessionInfo sessionInfo;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String showGreeting() {
		
		User user = sessionInfo.getCurrentUser();
		
		return "Hello " + user.getName() + " " + user.getSurname() + "!";
	}
	


}
