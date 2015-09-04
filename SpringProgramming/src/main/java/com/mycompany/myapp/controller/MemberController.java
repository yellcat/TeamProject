package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.service.MemberService;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private MemberService memberservice;//객체를 생성해주지 않아도 Autowired를 통해 생성
	
	@RequestMapping("member/joinForm")
	public String joininForm(){
		logger.info("joinForm()");
		return "member/joinForm";
	}
	
	@RequestMapping("member/loginForm")
	public String loginForm(){
		logger.info("loginForm()");
		return "member/loginForm";
	}
}
