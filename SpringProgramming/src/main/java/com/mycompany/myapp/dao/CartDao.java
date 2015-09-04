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

import com.mycompany.myapp.dto.Cart;

@Component
public class CartDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Integer insert(Cart cart) {
		Integer pk = null;
		String sql = "insert into carts (member_id, product_no, cart_amount) values (?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"cart_no"});				
				pstmt.setString(1, cart.getMemberId());
				pstmt.setInt(2, cart.getProductNo());
				pstmt.setInt(3, cart.getCartAmount());
				return pstmt;
			}
		}, keyHolder);
		
		pk = keyHolder.getKey().intValue();
		
		return pk;
	}
	
	public int update(Cart cart) {		
		String sql = "update carts set cart_amount =? where member_id = ? and product_no = ?";
		int rows = jdbcTemplate.update(sql, cart.getCartNo(), cart.getCartAmount(), cart.getMemberId(), cart.getProductNo());
		return rows;
	}
	
	public int delete(String memberId) {		
		String sql = "delete from carts where member_id = ?";	
		int rows = jdbcTemplate.update(sql, memberId);
		return rows;
	}
	
	public List <Cart> selectById (String memberId) {		
		String sql = "select * from carts where member_id = ?";
		
		List<Cart> list = jdbcTemplate.query(sql, new Object[]{memberId}, new RowMapper<Cart>(){

			@Override
			public Cart mapRow(ResultSet rs, int arg1) throws SQLException {
				Cart cart= new Cart();
				
				cart.setMemberId(rs.getString("member_id"));
				cart.setProductNo(rs.getInt("product_no"));
				cart.setCartAmount(rs.getInt("cart_amount"));
				cart.setCartNo(rs.getInt("cart_no"));
				
				return cart;				
			}			
		}
	);
		return list;			
	}
}
