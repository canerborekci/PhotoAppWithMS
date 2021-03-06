package com.appsdeveloperblog.photoapp.api.users.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.photoapp.api.users.business.abstracts.UserService;
import com.appsdeveloperblog.photoapp.api.users.business.dtos.UserDto;
import com.appsdeveloperblog.photoapp.api.users.models.CreateUserRequestModel;
import com.appsdeveloperblog.photoapp.api.users.models.CreateUserResponseModel;
import com.appsdeveloperblog.photoapp.api.users.security.AuthenticationFilter;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	private UserService userService;
	private Environment environment;
	
	@Autowired
	public UsersController(UserService userService, Environment environment) {
		this.userService = userService;
		this.environment = environment;

		
	}
	
	
	
	
	@GetMapping("/status/check")
	public String status() {
		return "working on : "+ environment.getProperty("local.server.port");
	}
	
	
	
	
	@PostMapping("add")
	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel createUserRequestModel) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserDto userDto = modelMapper.map(createUserRequestModel, UserDto.class);
		UserDto result = this.userService.createUser(userDto);
		CreateUserResponseModel returnValue = modelMapper.map(result, CreateUserResponseModel.class);
	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}
	

}
