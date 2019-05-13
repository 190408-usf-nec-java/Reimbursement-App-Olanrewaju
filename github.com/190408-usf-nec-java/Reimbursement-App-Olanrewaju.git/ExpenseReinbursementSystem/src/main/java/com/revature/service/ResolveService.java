package com.revature.service;

import com.revature.credentials.Credentials;
import com.revature.credentials.CredentialsResolve;
import com.revature.loginDao.ManagerDao;
import com.revature.loginDao.ResolveDao;

public class ResolveService {
	private ResolveDao resolveDao = new ResolveDao();
	
	public void resolve(CredentialsResolve credentialsResolve) {
		
		
		resolveDao.resolve(credentialsResolve);
	}
}
