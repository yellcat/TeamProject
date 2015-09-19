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
	public String join(String id, String pw, String name, String tel1, String tel2, String tel3, String address){
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setMobile(tel1+tel2+tel3);
		member.setAddress(address);
		
		logger.info("join()");
		memberservice.join(member);
		return "member/joinResult";
	}
	
	@RequestMapping("member/login")
	public String login(String mid, String mpass, HttpSession session, Model model){
		logger.info("login()");
		String result = memberservice.loginCheck(mid, mpass, session);
		model.addAttribute("result", result);
		
		return "member/result";
	}
	
	@RequestMapping("member/idCheck")
	public String idCheck(String mid, Model model){
		logger.info("idCheck()");
		String result = memberservice.idCheck(mid);
		model.addAttribute("result", result);
		return "member/result";
	}
	
	@RequestMapping("member/logout")
	public String logout(String mid, HttpSession session, Model model){
		logger.info("logout()");
		session.setAttribute("memberId", mid);
		String result="success";
		model.addAttribute("result", result);
		
		return "member/result";
	}
	
}
