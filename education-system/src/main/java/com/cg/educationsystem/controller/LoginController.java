package com.cg.educationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.educationsystem.entity.Login;
import com.cg.educationsystem.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@PostMapping("/validate")
	public ResponseEntity<String> loginValidation(@RequestBody Login login){
		String str=loginService.loginValidation(login);
		return new ResponseEntity<>(str,HttpStatus.OK);
	}
}
