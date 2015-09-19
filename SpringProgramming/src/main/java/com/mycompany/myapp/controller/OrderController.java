package com.mycompany.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.dto.Order;
import com.mycompany.myapp.service.OrderService;	

@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderservice;
	
	/*@RequestMapping("order/list")
	public String list(Model model, HttpSession session) {
		logger.info("list()");	
		
		String memberId = (String)session.getAttribute("memberId");
		
		List<Order> list = orderservice.getOrderlist(memberId);
		model.addAttribute("list", list);
		
		return "order/list";
	}*/
	
	@RequestMapping("order/list")
	public String list(@RequestParam(defaultValue="1") int pageNo, Model model, HttpSession session){
		logger.info("list()");
		
		session.setAttribute("pageNo", pageNo);
		
		String memberId = (String)session.getAttribute("memberId");
		
		int rowsPerPage = 10;
		int pagesPerGroup = 5;
		
		int totalBoardNo = orderservice.getTotalorderNo();
		
		int totalPageNo = totalBoardNo/rowsPerPage;
		if(totalBoardNo%rowsPerPage != 0){totalPageNo++;}
		
		int totalGroupNo = totalPageNo/pagesPerGroup;
		if(totalPageNo%pagesPerGroup != 0){totalGroupNo++;}
		
		int groupNo = (pageNo-1)/pagesPerGroup+1;
		int startPageNo = (groupNo-1)*pagesPerGroup+1;
		int endPageNo = startPageNo + pagesPerGroup-1;
		if(groupNo==totalGroupNo) {endPageNo = totalPageNo;}
		
		List<Order> list = orderservice.getPage(memberId, pageNo, rowsPerPage);
		model.addAttribute("list", list);		
		
		model.addAttribute("memberId", memberId);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("list", list);
		
		return "order/list";
		
	}
	
}
