package com.mycompany.myapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.MemberDao;
import com.mycompany.myapp.dao.OrderDao;
import com.mycompany.myapp.dao.OrderProductDao;
import com.mycompany.myapp.dao.ProductDao;
import com.mycompany.myapp.dto.Member;
import com.mycompany.myapp.dto.Order;
import com.mycompany.myapp.dto.OrderProduct;
import com.mycompany.myapp.dto.Product;


@Component
public class OrderProductService {
	@Autowired
	private OrderProductDao opdao;
	@Autowired
	private ProductDao pdao;
	@Autowired
	private MemberDao mdao;
	@Autowired
	private OrderDao odao;
	

	public void insert(OrderProduct orderproduct){
		opdao.insert(orderproduct);
	}
	
	public List<OrderProduct> getPage(int rownum, int rowPerPage, int orderno){
		List<OrderProduct> list = opdao.selectByPk(rownum,rowPerPage,orderno);
		
		List<OrderProduct> Olist = new ArrayList<OrderProduct>();
		
		Order order=odao.selectByPk(orderno);
		
		Member member=mdao.selectById(order.getId());
		
		for(OrderProduct op : list){
			Product product=pdao.selectByPk(op.getProductno());
			op.setProductname(product.getName());
			op.setProductprice(product.getPrice());
			op.setMembername(member.getName());
			op.setAllprice(order.getPrice());
			
			Olist.add(op);
			
			
			
		}
	
	
		return list;
	}
	
	
	public int getTotalproductNo(){
		return opdao.selectCount();
	}
}
