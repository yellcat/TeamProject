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

import com.mycompany.myapp.dto.OrderProduct;
import com.mycompany.myapp.service.OrderProductService;

@Controller
public class OrderProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderProductController.class);
	
	@Autowired
	private OrderProductService orderproductservice;//객체를 생성해주지 않아도 Autowired를 통해 생성
	
	@RequestMapping("orderproduct/list")
	public String list(@RequestParam(defaultValue="1") int pageNo,int orderNo, Model model, HttpSession session){
		logger.info("list()");
		
		session.setAttribute("pageNo",pageNo);
		session.setAttribute("orderNo",orderNo);
		
		int rowsPerPage = 10;
		int pagesPerGroup = 5;
		
		int totalBoardNo = orderproductservice.getTotalproductNo();
		
		int totalPageNo = totalBoardNo/rowsPerPage;
		if(totalBoardNo%rowsPerPage != 0){totalPageNo++;}
		
		int totalGroupNo = totalPageNo/pagesPerGroup;
		if(totalPageNo%pagesPerGroup!=0){totalGroupNo++;}
			
		int groupNo = (pageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup +1;
		int endPageNo = startPageNo + pagesPerGroup -1;
		if (groupNo==totalGroupNo) {endPageNo = totalPageNo;}
		
		List<OrderProduct> list = orderproductservice.getPage(pageNo, rowsPerPage,orderNo);
		model.addAttribute("list", list);
		
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("orderNo",orderNo);
		model.addAttribute("list", list);

		return "orderproduct/list";
	}
}
