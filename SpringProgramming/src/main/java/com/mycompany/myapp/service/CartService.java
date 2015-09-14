package com.mycompany.myapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.CartDao;
import com.mycompany.myapp.dao.OrderDao;
import com.mycompany.myapp.dao.OrderProductDao;
import com.mycompany.myapp.dao.ProductDao;
import com.mycompany.myapp.dto.Cart;
import com.mycompany.myapp.dto.Order;
import com.mycompany.myapp.dto.OrderProduct;
import com.mycompany.myapp.dto.Product;

@Component
public class CartService {
	@Autowired
	private CartDao cdao;
	@Autowired
	private ProductDao pdao;
	@Autowired
	private OrderDao odao;
	@Autowired
	private OrderProductDao opdao;
	
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
			Product product = pdao.selectByPk(cart.getProductNo());
			cart.setName(product.getName());
			cart.setPrice(product.getPrice());
			list.add(cart);
		}
		return list;
	}
	
	public int getAllPrice(List<Cart> list){
		int AllPrice=0;
		
		for(Cart cart : list){
			AllPrice+=cart.getAmount()*cart.getPrice();
		}
		
		return AllPrice;
	}
	
	public void order(String memberId, int AllPrice, String Payment){
		List<Cart> list = cdao.selectById(memberId);
		
		cdao.delete(memberId);
		Order order = new Order();
		order.setId(memberId);
		order.setPayment(Payment);
		order.setPrice(AllPrice);
		
		int orderno = odao.insert(order);
		
		for(Cart cart : list){
			OrderProduct orderp = new OrderProduct();
			orderp.setOrderno(orderno);
			orderp.setProductno(cart.getProductNo());
			orderp.setOrderproductamount(cart.getAmount());
			opdao.insert(orderp);
		}
		
	}
}
