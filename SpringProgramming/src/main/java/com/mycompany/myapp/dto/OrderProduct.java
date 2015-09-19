package com.mycompany.myapp.dto;

public class OrderProduct {
	private int orderno;
	private int orderproductamount;
	private int productno;
	private int orderproductno;
	private String membername;
	private String productname;
	private int productprice;
	private int allprice;
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
	public int getAllprice() {
		return allprice;
	}
	public void setAllprice(int allprice) {
		this.allprice = allprice;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public int getOrderproductamount() {
		return orderproductamount;
	}
	public void setOrderproductamount(int orderproductamount) {
		this.orderproductamount = orderproductamount;
	}
	public int getProductno() {
		return productno;
	}
	public void setProductno(int productno) {
		this.productno = productno;
	}
	public int getOrderproductno() {
		return orderproductno;
	}
	public void setOrderproductno(int orderproductno) {
		this.orderproductno = orderproductno;
	}
}
