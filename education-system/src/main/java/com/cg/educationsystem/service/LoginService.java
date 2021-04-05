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
		if(loginRepository.existsById(login.getUserId())) {
			Login newLogin=loginRepository.findById(login.getUserId()).get();
			if(newLogin.getUserId().contentEquals(login.getUserId())&&
					newLogin.getUserPassword().contentEquals(login.getUserPassword())&&
					newLogin.getRole().contentEquals(login.getRole())) {
				return "Logged in successfully";	
			}
			else {
				return "Please enter correct UserId or Password";
			}
		}
		else {
			return "Please enter correct UserId or Password";
		}
	}

}
