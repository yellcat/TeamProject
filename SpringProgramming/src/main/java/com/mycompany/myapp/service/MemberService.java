package com.mycompany.myapp.service;

import com.mycompany.myapp.dao.MemberDao;
import com.mycompany.myapp.dto.Member;

public class MemberService {
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
