package com.mycompany.myapp.dto;

public class OrderProduct {
	private int orderno;
	private int orderproductamount;
	private int productno;
	private int orderproductno;
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
