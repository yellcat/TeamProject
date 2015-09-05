package com.mycompany.myapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.dto.Cart;
import com.mycompany.myapp.service.CartService;

@Controller
public class CartController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private CartService cartservice;
	
	@RequestMapping("/cart/list")
	public String list(String memberId, Model model) {
		logger.info("list()");
		memberId="aaaa";
		List<Cart> list = cartservice.getCart(memberId);	
		model.addAttribute("list", list);
		return "cart/list";
	}
	
	@RequestMapping("cart/add")
	public String add(String memberId, int productNo, int cartAmount) {
		logger.info("add()");
		Cart cart = new Cart();
		cart.setMemberId(memberId);
		cart.setProductNo(productNo);
		cart.setAmount(cartAmount);
		cartservice.insert(cart);
		
		return "redirect:/product/list";
	}
	
}
