package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.OrderProductDao;
import com.mycompany.myapp.dto.OrderProduct;
import com.mycompany.myapp.dto.Product;

@Component
public class OrderProductService {
	@Autowired
	private OrderProductDao opdao;
	

	public void insert(OrderProduct orderproduct){
		opdao.insert(orderproduct);
	}
	
	public List<OrderProduct> getPage(int rownum, int rowPerPage, int orderno){
		List<OrderProduct> list = opdao.selectByPk(rownum,rowPerPage,orderno);
		return list;
	}
	
	public int getTotalproductNo(){
		return opdao.selectCount();
	}
}
