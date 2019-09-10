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

/**
 * Servlet implementation class ProductS
 */
@WebServlet("/prod")
public class ProductS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao productDao =new ProductDaoImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		System.out.println("product called");
		 PrintWriter out=	response.getWriter();
		 
		 try
		 {
			 HttpSession session=request.getSession(false);
		 
			String sname=session.getAttribute("sname").toString();
			out.print(sname);
			RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
			rd.include(request,response);
		List<Product> products=productDao.getProducts();
		out.print("<table border='1'><tr>");
		out.print("<th> Product Id</th>");
		out.print("<th> Product Name</th>");
		out.print("<th> Cost</th>");
		out.print("<th> Quantity</th>");
		out.print("</tr>");
		for(Product p:products)
		{
			out.print("<tr>");
			out.print("<td>"+p.getProductid()+"</td>");
			out.print("<td>"+p.getPname()+"</td>");
			out.print("<td>"+p.getCost()+"</td>");
			out.print("<td>"+p.getQty()+"</td>");
			out.print("<td>"+p.getProductid()+"</td>");
			out.print("<td><a href='Edit?pid="+p.getProductid()+"'>Edit</td>");
			out.print("<td><a href='delete?productid="+p.getProductid()+"'>Delete</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		rd.include(request,response);
		 }
		 finally {}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
