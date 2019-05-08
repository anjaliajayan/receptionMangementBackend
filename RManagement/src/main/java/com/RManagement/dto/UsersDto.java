package com.RManagement.dto;


import lombok.Data;

@Data
public class UsersDto {
	private Integer user_id;

	private String username;

	private String password;

	private Integer role_id;

	private String role;
	
}
