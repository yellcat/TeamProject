package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.OrderDao;
import com.mycompany.myapp.dto.Order;

@Component
public class OrderService {
	@Autowired
	private OrderDao odao;
	
	public void insert(Order order) {
		odao.insert(order);
	}
	
	public Order getOrder(int orderNo) {
		Order order = odao.selectByPk(orderNo);
		return order;		
		
	}
	
	public List<Order> getOrderlist(String member_id) {
		List<Order> list = odao.selectById(member_id);
		return list;		
		
	}
	
	public List<Order> getPage(String member_id, int rownum, int rowPerPage) {
		List<Order> list = odao.selectByPage(member_id, rownum, rowPerPage);
		return list;
	}
	
	public int getTotalorderNo() {
		return odao.selectCount();
	}
	
}
