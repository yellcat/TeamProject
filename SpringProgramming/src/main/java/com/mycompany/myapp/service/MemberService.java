package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.MemberDao;
import com.mycompany.myapp.dto.Member;
@Component
public class MemberService {
	@Autowired
	MemberDao mdao = new MemberDao();
	
	public void join(Member member) {
		mdao.insert(member);
	}
	
	public Member getMember(String memberId){
		Member member = mdao.selectById(memberId);
		return member;
	}
	
	public void delete(String memberId){
		mdao.delete(memberId);
	}	

}
