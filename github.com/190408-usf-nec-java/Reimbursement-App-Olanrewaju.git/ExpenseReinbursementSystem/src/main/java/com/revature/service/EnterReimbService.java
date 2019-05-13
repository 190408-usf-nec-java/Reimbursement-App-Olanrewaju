package com.revature.service;

import com.revature.credentials.CredentialsTicket;
import com.revature.credentials.ReimbursementData;
import com.revature.loginDao.EnterReimbDao;

public class EnterReimbService {

	private EnterReimbDao enterReimbDao = new EnterReimbDao();
	
	public void enterReimb(CredentialsTicket credentialTickets, ReimbursementData data) {
		
		
		
		enterReimbDao.EnterReimb(credentialTickets, data);
	}
}
