package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.mycompany.myapp.dto.OrderProduct;

@Component
public class OrderProductDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Integer insert(OrderProduct orderproduct) {
		Integer pk = null;
		String sql = "insert into orderproducts (orderproduct_no, order_no, product_no, orderproduct_amount) "
				+ "values (?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "ORDERPRODUCT_NO" });
				pstmt.setInt(1, orderproduct.getOrderproductno());
				pstmt.setInt(2, orderproduct.getOrderno());// (?의 순번,)
				pstmt.setInt(3, orderproduct.getProductno());
				pstmt.setInt(4, orderproduct.getOrderproductamount());
				return pstmt;
			}

		}, keyHolder);
		Number keyNumber = keyHolder.getKey();
		pk = keyNumber.intValue();
		return pk;
	}
	
	
	public List<OrderProduct> selectByPk(int rownum, int rowPerPage, int orderno) {
		String sql = "select orderproduct_no, order_no, product_no, orderproduct_amount from orderproducts"
				+ "order by orderproduct_no desc "
				+ "limit ?,?"
				+ "where order_no=? ";
		List<OrderProduct> list=jdbcTemplate.query
		(sql,
			new Object[] {(rownum-1)*rowPerPage, rowPerPage,orderno},
			new RowMapper<OrderProduct>() { 
				@Override
				public OrderProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
					OrderProduct orderproduct = new OrderProduct();
					orderproduct.setOrderproductno(rs.getInt("orderproduct_no"));
					orderproduct.setOrderno(rs.getInt("order_no"));
					orderproduct.setOrderproductno(rs.getInt("product_no"));
					orderproduct.setOrderproductamount(rs.getInt("orderproduct_amount"));
					
					return orderproduct;
				}
			}
		);
		return list;
	}
	
	public int selectCount(){
		String sql = "select count(*) from orderproducts";
		int rows = jdbcTemplate.queryForObject(sql, Integer.class);
		return rows;
	}
}
