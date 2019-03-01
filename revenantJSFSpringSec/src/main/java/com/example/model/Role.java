package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="user_roles",schema = "public")
public class Role {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long user_role_id;
	
	@Column
	private String username;
	
	@Column
	private String role;
	

}
