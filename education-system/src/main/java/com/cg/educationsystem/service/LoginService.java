package com.cg.educationsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.educationsystem.dao.ILoginRepository;
import com.cg.educationsystem.entity.Login;

@Service
public class LoginService implements ILoginService {
	@Autowired
	ILoginRepository loginRepository;
	@Override
	public Login loginValidation(String userId,String userPassword) {
		Login login=loginRepository.validate(userId, userPassword);
		return login;
	}

}
