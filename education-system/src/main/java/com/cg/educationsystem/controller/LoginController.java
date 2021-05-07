package com.cg.educationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.educationsystem.entity.Login;
import com.cg.educationsystem.service.LoginService;
import com.cg.educationsystem.utils.InvalidUserIdOrPasswordException;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@PostMapping("/validate")
	public ResponseEntity<Login> loginValidation(@RequestBody Login login){
		Login newLogin=loginService.loginValidation(login.getUserId(),login.getUserPassword(),login.getRole());
		if(newLogin==null) {
			throw new InvalidUserIdOrPasswordException("Invalid username or password");
		}
		return new ResponseEntity<>(newLogin,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody Login login){
		loginService.addUser(login);
		return new ResponseEntity<>("User added",HttpStatus.OK);
	}
}
