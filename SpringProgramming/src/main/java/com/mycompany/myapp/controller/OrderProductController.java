package com.mycompany.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.dto.OrderProduct;
import com.mycompany.myapp.service.OrderProductService;

@Controller
public class OrderProductController {
	@Autowired
	private OrderProductService orderproductservice;//객체를 생성해주지 않아도 Autowired를 통해 생성
	
	
	@RequestMapping("orderproduct/detail")
	public String detail(int orderproductno, HttpServletRequest request){
		OrderProduct orderproduct = orderproductservice.getOrderProduct(orderproductno);
		request.setAttribute("orderproduct", orderproduct);
		return "orderproduct/detail";
	}
}
