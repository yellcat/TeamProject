package com.mycompany.myapp.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.dto.Member;
import com.mycompany.myapp.service.MemberService;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private MemberService memberservice;//媛앹껜瑜� �깮�꽦�빐二쇱� �븡�븘�룄 Autowired瑜� �넻�빐 �깮�꽦
	
	@RequestMapping("member/joinForm")
	public String joininForm(){
		logger.info("joinForm()");
		return "member/joinForm";
	}
	
	@RequestMapping("member/join")
	public String join(Member member){
		logger.info("join()");
		memberservice.join(member);
		return "member/join";
	}
	
	@RequestMapping("member/login")
	public String login(String mid, String mpass, HttpSession session, Model model){
		logger.info("login()");
		String result = memberservice.loginCheck(mid, mpass, session);
		model.addAttribute("result", result);
		
		return "member/result";
	}
	
}
