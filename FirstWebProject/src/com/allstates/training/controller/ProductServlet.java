package com.allstates.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allstate.training.pojos.Product;
import com.allstates.training.dao.ProductDao;
import com.allstates.training.dao.ProductDaoImpl;

@WebServlet("/Product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao productDao =new ProductDaoImpl();
	
  public ProductServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 PrintWriter out=	response.getWriter();
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
		out.print("</tr>");
		
	}
	out.print("</table>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
