package com.allstates.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public logoutServlet() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		
		HttpSession session=request.getSession(false);
		session.removeAttribute("sname");
		session.invalidate();
		out.print("login again");
		response.sendRedirect("Login.html");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
