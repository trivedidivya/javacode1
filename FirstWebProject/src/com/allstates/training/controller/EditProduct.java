package com.allstates.training.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allstate.training.pojos.Product;
import com.allstates.training.dao.ProductDao;
import com.allstates.training.dao.ProductDaoImpl;


@WebServlet("/Edit")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao productDao=new ProductDaoImpl();
       public EditProduct() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int pid=Integer.parseInt(request.getParameter("pid"));
	Product p=productDao.getProductById(pid);
	request.setAttribute("prods", p);
	RequestDispatcher rd=request.getRequestDispatcher("addproduct.jsp");
	rd.include(request,response);
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
