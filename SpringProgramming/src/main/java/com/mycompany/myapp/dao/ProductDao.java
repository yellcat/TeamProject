package com.mycompany.myapp.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Product;
@Component
public class ProductDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Product> selectByPage(int rownum, int rowPerPage){
		String sql = ""
				+ "select product_no, product_name, product_price "
				+ "from products order by product_no desc "
				+ "limit ?,?";
		
		List<Product> list = jdbcTemplate.query(
				sql, 
				new Object[] {(rownum-1)*rowPerPage, rowPerPage},
				new RowMapper<Product>(){

					@Override
					public Product mapRow(ResultSet rs, int rowNo) throws SQLException {
						Product product = new Product();
						product.setNo(rs.getInt("product_no"));
						product.setName(rs.getString("product_name"));
						product.setPrice(rs.getInt("product_price"));
						
						return product;
					}
				});
		return list;
	}
	
	public Product selectByPk(int productNo){
		String sql = "select * from products where product_no = ?";
		Product product = jdbcTemplate.queryForObject(
				sql, 
				new Object[]{productNo},
				new RowMapper<Product>(){

					@Override
					public Product mapRow(ResultSet rs, int rowNo) throws SQLException {
						Product product = new Product();
						
						product.setNo(rs.getInt("product_no"));
						product.setName(rs.getString("product_name"));
						product.setPrice(rs.getInt("product_price"));
						product.setOriginalFilename(rs.getString("product_original_file_name"));
						product.setFilesystemName(rs.getString("product_filesystem_name"));
						product.setContentType(rs.getString("product_content_type"));

						return product;
					}
				}
			);
		return product;
	}

	public int selectCount(){
		String sql = "select count(*) from products";
		int rows = jdbcTemplate.queryForObject(sql, Integer.class);
		return rows;
	}
}
