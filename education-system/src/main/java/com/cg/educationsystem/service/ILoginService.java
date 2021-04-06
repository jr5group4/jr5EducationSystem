package com.cg.educationsystem.service;

import com.cg.educationsystem.entity.Login;

public interface ILoginService {
	//to validate user id and password 
	public String loginValidation(Login login);
}
