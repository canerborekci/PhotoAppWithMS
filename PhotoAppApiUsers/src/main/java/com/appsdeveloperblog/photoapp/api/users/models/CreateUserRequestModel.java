package com.appsdeveloperblog.photoapp.api.users.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestModel {
	@NotNull
	@Size(min=2)
	private String firstName;
	
	@NotNull
	@Size(min=2)
	private String lastName;
	
	@NotNull
	@Email
	private String email;
	
	@Size(min=8 , max=20)
	private String password;
	
}
