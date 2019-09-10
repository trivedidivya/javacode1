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

@WebServlet("/addProduct")
public class addProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao productDao =new ProductDaoImpl();
    public addProductServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		 PrintWriter out=	response.getWriter();
		 HttpSession session=request.getSession(false);
			String sname=session.getAttribute("sname").toString();
			out.print(sname);
			System.out.println("called");
		Product p=new Product();
		String pid=request.getParameter("productid");
		p.setPname(request.getParameter("productname"));
		p.setCost(Integer.parseInt(request.getParameter("cost")));
		p.setQty(Integer.parseInt(request.getParameter("quantity")));
		
		if(pid.isEmpty())
		{	
			int i=productDao.addProduct(p);
			if(i>0)
			{
			RequestDispatcher rd1=request.getRequestDispatcher("prod");
			rd1.forward(request, response);
			}
			else {
				System.out.println("product not added");
				RequestDispatcher rd=request.getRequestDispatcher("addproduct.jsp");
				rd.include(request,response);
			}
		}else {
			p.setProductid(Integer.parseInt(pid));
			int i=productDao.updateProduct(p);
			if(i>0)
			{
			RequestDispatcher rd2=request.getRequestDispatcher("prod");
			rd2.include(request,response);
			}
			else
			{
				System.out.println("product not updated");
				RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
				rd.include(request,response);
			}
			
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
