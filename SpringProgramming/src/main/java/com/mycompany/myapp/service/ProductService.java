package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.ProductDao;
import com.mycompany.myapp.dto.Product;

@Component
public class ProductService {
	@Autowired
	private ProductDao pdao;
		
	public List<Product> getPage(int rownum, int rowPerPage){
		List<Product> list = pdao.selectByPage(rownum,rowPerPage);
		return list;
	}
	
	public Product getProduct(int productNo){
		Product product = pdao.selectByPk(productNo);
		return product;
	}
	
	public int getTotalproductNo(){
		return pdao.selectCount();
	}
}
