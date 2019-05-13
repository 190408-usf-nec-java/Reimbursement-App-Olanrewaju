package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.credentials.Credentials;
import com.revature.credentials.CredentialsTicket;
import com.revature.credentials.ReimbursementData;
import com.revature.loginDao.LoginDao;
import com.revature.service.EnterReimbService;


public class EnterReimbServlet extends DefaultServlet{
	EnterReimbService enterReimbService = new EnterReimbService();
	ObjectMapper m = new ObjectMapper();
	LoginServlet loginServlet = new LoginServlet();
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		//response.addHeader("Access-Control-Allow-Headers", "content-type");
		super.service(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		System.out.println("inside of doPost");

		ObjectMapper om = new ObjectMapper();
		CredentialsTicket credentialsTicket = om.readValue(request.getInputStream(), CredentialsTicket.class);
		
	
		LoginDao dao = new LoginDao();
		ReimbursementData myRe = loginServlet.data();

		// Pass credentials to service
		enterReimbService.enterReimb(credentialsTicket, myRe);
		System.out.println(credentialsTicket);
		System.out.println(myRe);
		
		//System.out.println("Java Object: " + myRe);
	}
}
