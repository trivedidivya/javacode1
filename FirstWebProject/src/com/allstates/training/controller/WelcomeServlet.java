package com.allstates.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.allstate.training.pojos.Product;
import com.allstates.training.dao.ProductDao;
import com.allstates.training.dao.ProductDaoImpl;

@WebServlet("/Welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao productDao =new ProductDaoImpl();
    public WelcomeServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		if(email.contains("allstate"))
		{
		pw.print("Welcome "+ email);
		HttpSession session=request.getSession();
		session.setAttribute("sname", email);
		RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
		rd.include(request,response);
		 
		}
		else
		{
			pw.print("invalid credentials");
			/* getrequestDispatcher will redirect to file within the application*/
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request,response);/*this post the response on login .html page along with original content of page */
		/*this will redirect to external link or file */
			//response.sendRedirect("http://www.hdfc.com");
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
