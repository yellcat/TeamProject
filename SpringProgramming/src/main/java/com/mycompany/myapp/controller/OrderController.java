package com.mycompany.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.dto.Order;
import com.mycompany.myapp.service.OrderService;	

@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderservice;
	
	@RequestMapping("order/list")
	public String list(Model model, HttpSession session) {
		logger.info("list()");
		
		List<Order> list = orderservice.getOrderlist("member_id");
		model.addAttribute("list", list);
		
		return "order/list";
	}
	
	@RequestMapping("order/detail")
	public String detail(int orderNo, HttpServletRequest request) {
		logger.info("detail()");
		Order order = orderservice.getOrder(orderNo);
		request.setAttribute("order", order);
		return "order/detail";
	}	
	
}
