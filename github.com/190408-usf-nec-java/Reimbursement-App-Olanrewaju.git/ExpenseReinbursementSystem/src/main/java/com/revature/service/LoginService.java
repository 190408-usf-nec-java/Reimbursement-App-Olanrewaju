package com.revature.service;

import com.revature.credentials.Credentials;
import com.revature.loginDao.LoginDao;

public class LoginService {
private LoginDao loginDao = new LoginDao();
	
	public void login(Credentials credentials) {
		// Ensure that username meets username standards
		
		// Ensure that password meets password standards
		
		// Check if username already exists

		loginDao.login(credentials);
		
		
	}
}
