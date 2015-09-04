package com.mycompany.myapp.dto;

public class Cart {

	private String memberId;
	private int productNo;
	private String productName;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	private int cartAmount;
	private int cartNo;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getCartAmount() {
		return cartAmount;
	}
	public void setCartAmount(int cartAmount) {
		this.cartAmount = cartAmount;
	}
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
}
