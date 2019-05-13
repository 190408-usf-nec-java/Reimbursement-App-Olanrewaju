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
import com.revature.credentials.ReimbursementData;
import com.revature.loginDao.LoginDao;
import com.revature.service.LoginService;

@WebServlet
public class LoginServlet extends DefaultServlet {

	LoginService LoginService = new LoginService();
	ObjectMapper m = new ObjectMapper();
	ReimbursementData myRe = new ReimbursementData();
	Credentials credentials = new Credentials();


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
		credentials = om.readValue(request.getInputStream(), Credentials.class);

		// Pass credentials to service
		LoginService.login(credentials);
		System.out.println(credentials);
		
		
		//System.out.println("Java Object: " + myRe);
		LoginDao dao = new LoginDao();
		myRe = dao.login(credentials);
		
		String myJ = m.writeValueAsString(myRe);
		
		System.out.println("Json Object: " + myRe.toString());
		
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(myJ);

	}
	
	public ReimbursementData data() {
		return myRe;
	}
	
	

}
