package com.mycompany.myapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.CartDao;
import com.mycompany.myapp.dao.ProductDao;
import com.mycompany.myapp.dto.Cart;

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
		List<Cart> list = new ArrayList<Cart>();
		
		for(Cart cart : clist){
			cart.setProductName(pdao.selectByPk(cart.getProductNo()).getName());
			list.add(cart);
		}
		return list;
	}
}
