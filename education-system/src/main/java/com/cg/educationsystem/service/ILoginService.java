package com.cg.educationsystem.service;

import com.cg.educationsystem.entity.Login;

public interface ILoginService {
	//to validate user id and password 
	public Login loginValidation(String userId,String userPassword,String role);
	public void addUser(Login login);
}
