package com.mycompany.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	@RequestMapping("cart/list")
	public String list(HttpSession session, Model model) {
		logger.info("list()");
		String memberId = (String)session.getAttribute("memberId");
		logger.info(memberId);
		List<Cart> list = cartservice.getCart(memberId);	
		int AllPrice = cartservice.getAllPrice(list);
		
		model.addAttribute("list", list);
		model.addAttribute("AllPrice", AllPrice);
		
		return "cart/list";
	}
	
	@RequestMapping("cart/add")
	public String add(HttpSession session, int productno, int amount) {
		logger.info("add()");
		String memberId = (String)session.getAttribute("memberId");
		
		Cart cart = new Cart();
		cart.setMemberId(memberId);
		cart.setProductNo(productno);
		cart.setAmount(amount);
		cartservice.insert(cart);
		
		return "redirect:/product/list";
	}
	
	@RequestMapping("cart/orderForm")
	public String orderForm(HttpSession session, int AllPrice, Model model) {
		logger.info("orderForm()");
		String memberId = (String)session.getAttribute("memberId");
		List<Cart> list = cartservice.getCart(memberId);
		model.addAttribute("list", list);
		model.addAttribute("AllPrice", AllPrice);
		return "cart/orderForm";
	}
	
	@RequestMapping("cart/order")
	public String order(HttpSession session, int AllPrice, String Payment, Model model) {
		logger.info("order()");
		String memberId = (String)session.getAttribute("memberId");
		logger.info(String.valueOf(AllPrice));
		cartservice.order(memberId, AllPrice, Payment);
		
		return "redirect:list";
	}
	
}
