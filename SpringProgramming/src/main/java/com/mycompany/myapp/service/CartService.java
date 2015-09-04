package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.CartDao;
import com.mycompany.myapp.dto.Cart;

@Component
public class CartService {
	@Autowired
	private CartDao cdao;
	
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
		List<Cart> list = cdao.selectById(memberId);
		return list;
	}
}
