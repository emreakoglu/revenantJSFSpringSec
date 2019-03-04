package com.example.primefaces;

import javax.inject.Named;

import org.springframework.stereotype.Controller;


@Controller(value = "login")
public class Login {
	
	private String firstName = "";
	private String lastName = "";
	
	

	
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

	public void method() {
		System.out.println("asdadadad");
	}

}
