package com.allstates.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/delete")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao productDao =new ProductDaoImpl();
    public deleteServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=	response.getWriter();
		 HttpSession session=request.getSession(false);
			String sname=session.getAttribute("sname").toString();
			out.print(sname);
		int i= productDao.deleteProduct(Integer.parseInt(request.getParameter("productid")));
		if(i>0)
		{
		RequestDispatcher rd=request.getRequestDispatcher("prod");
		rd.include(request,response);
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
