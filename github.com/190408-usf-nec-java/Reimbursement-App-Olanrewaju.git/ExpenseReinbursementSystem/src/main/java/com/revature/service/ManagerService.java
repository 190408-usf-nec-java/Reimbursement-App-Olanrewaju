package com.revature.service;

import com.revature.credentials.Credentials;
import com.revature.loginDao.ManagerDao;

public class ManagerService {

		private ManagerDao managerDao = new ManagerDao();
		
		public void login(Credentials credentials) {
			
			
			managerDao.login(credentials);
		}
}
