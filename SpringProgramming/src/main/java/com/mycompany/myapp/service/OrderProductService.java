package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.OrderProductDao;
import com.mycompany.myapp.dto.OrderProduct;

@Component
public class OrderProductService {
	@Autowired
	private OrderProductDao opdao;
	

	public void insert(OrderProduct orderproduct){
		opdao.insert(orderproduct);
	}
	
	public OrderProduct getOrderProduct(int orderproductno){
		OrderProduct orderproduct = opdao.selectByPk(orderproductno);
		return orderproduct;
	}
}
