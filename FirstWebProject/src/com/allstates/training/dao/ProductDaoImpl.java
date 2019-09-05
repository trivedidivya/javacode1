package com.allstates.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
	private Connection con=null;
	public ProductDaoImpl() {
		
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/allstates","root","admin");
		} catch (Exception e) {
			System.out.println("d connection problem");
			e.printStackTrace();
		}
	}

	@Override
	public int addProduct(Product p) {
		int i=0;
		try
		{
		String sql="insert into product values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, p.getProductid());
		ps.setString(2,p.getPname());
		ps.setInt(3, p.getCost());
		ps.setInt(4, p.getQty());
		i=ps.executeUpdate();
		
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return i;
	}

	@Override
	public int updateProductQuantity(int Productid, int qty) {
		int i=0;
		try {String sql="update product set qty=? where Productid=? ";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, qty);
			ps.setInt(2, Productid);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateProductCost(int Productid, int cost) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int Productid) {
		int i=0;
		try {String sql="delete from product where Productid=? ";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Productid);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Product getProductById(int Productid) {
		
		Product p=new Product();
		try {
			String sql="select * from product where productid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Productid);
			ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			p.setCost(rs.getInt(3));
			p.setPname(rs.getString(2));
			p.setProductid(rs.getInt(1));
			p.setQty(rs.getInt(4));
		}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Product> getProducts() {
		List<Product> products =new ArrayList<>();
		String sql="select * from product";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				Product p=new Product();
				p.setCost(rs.getInt(3));
				p.setPname(rs.getString(2));
				p.setProductid(rs.getInt(1));
				p.setQty(rs.getInt(4));
				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

}
