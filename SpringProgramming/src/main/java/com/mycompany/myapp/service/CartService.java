package com.mycompany.myapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.CartDao;
import com.mycompany.myapp.dao.ProductDao;
import com.mycompany.myapp.dto.Cart;
import com.mycompany.myapp.dto.Product;

@Component
public class CartService {
	@Autowired
	private CartDao cdao;
	@Autowired
	private ProductDao pdao;
	
	public void insert(Cart cart) {
		cdao.insert(cart);
	}
	
	public void update(Cart cart) {
		cdao.update(cart);
	}
	
	public void delete(String memberId) {
		cdao.delete(memberId);
	}
	
	public List<Cart> getCart(String memberId) {
		List<Cart> clist = cdao.selectById(memberId);
		System.out.println("getCart()");
		List<Cart> list = new ArrayList<Cart>();
		System.out.println("CartList");
		for(Cart cart : clist){
			System.out.println("for문");
			Product product = pdao.selectByPk(cart.getProductNo());
			cart.setName(product.getName());
			cart.setPrice(product.getPrice());
			System.out.println("for문2");
			list.add(cart);
			System.out.println("for문2");
		}
		return list;
	}
}
