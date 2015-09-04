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

import com.mycompany.myapp.dto.Order;
import com.mycompany.myapp.dto.Product;
import com.mycompany.myapp.dto.OrderProduct;

@Component
public class OrderProductDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Integer insert(OrderProduct orderproduct) {
		Integer pk = null;
		String sql = "insert into ORDERPRODUCTS (orderproduct_no, order_no, product_no, orderproduct_amount) "
				+ "values (orderproducts_seq.nextval, ?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "ORDERPRODUCT_NO" });
				pstmt.setInt(1, orderproduct.getOrderno());// (?의 순번,)
				pstmt.setInt(2, orderproduct.getProductno());
				pstmt.setInt(3, orderproduct.getOrderproductamount());
				return pstmt;
			}

		}, keyHolder);
		Number keyNumber = keyHolder.getKey();
		pk = keyNumber.intValue();
		return pk;
	}
	
	
	public OrderProduct selectByPk(int orderproductno) {
		String sql = "select * from orderproducts where orderproduct_no=?";
		OrderProduct orderproduct=jdbcTemplate.queryForObject(sql,
			new Object[] {orderproductno},
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
		return orderproduct;
	}
	
	
}
