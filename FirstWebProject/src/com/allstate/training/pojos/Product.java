package com.allstate.training.pojos;


import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private int productid;
	private String pname;
	private int cost;
	private int qty;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", pname=" + pname + ", cost=" + cost + ", qty=" + qty + "]";
	}

}
