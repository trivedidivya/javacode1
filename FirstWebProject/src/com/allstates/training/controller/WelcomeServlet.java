package com.allstates.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public WelcomeServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		if(email.contains("allstate")) {
		pw.print("Welcome "+ email);
		RequestDispatcher rd=request.getRequestDispatcher("MENU.html");
		rd.include(request,response);
		}
		else
		{
			pw.print("invalid credentials");
			/* getrequestDispatcher will redirect to file within the application*/
			//RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			//rd.include(request,response);/*this post the response on login .html page along with original content of page */
		/*this will redirect to external link or file */
			response.sendRedirect("http://www.hdfc.com");
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
