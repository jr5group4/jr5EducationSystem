package com.cg.educationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.educationsystem.dao.ILoginRepository;
import com.cg.educationsystem.entity.Login;

@Service
public class LoginService implements ILoginService {
	@Autowired
	ILoginRepository loginRepository;
	@Override
	public String loginValidation(Login login) {
		if(loginRepository.equals(login)) {
			return "Logged in successfully";
		}
		else {
			return "Please enter correct UserId or Password";
		}
	}

}
