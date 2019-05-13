package com.revature.servlets;
import java.awt.List;
import com.revature.loginDao.*;
import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.credentials.Credentials;
import com.revature.credentials.CredentialsResolve;
import com.revature.credentials.ReimbursementData;
import com.revature.loginDao.LoginDao;
import com.revature.service.ManagerService;
import com.revature.service.ResolveService;

@WebServlet
public class Resolve extends DefaultServlet {

	ResolveService resolveService = new ResolveService();
	ObjectMapper m = new ObjectMapper();
	ReimbursementData myRe = new ReimbursementData();
	CredentialsResolve credentialsResolve = new CredentialsResolve();


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
		credentialsResolve = om.readValue(request.getInputStream(), CredentialsResolve.class);

		// Pass credentials to service
		resolveService.resolve(credentialsResolve);
		System.out.println(credentialsResolve);
		
		
		//System.out.println("Java Object: " + myRe);
		
		

	}
	
	public ReimbursementData data() {
		return myRe;
	}
	
	

}
