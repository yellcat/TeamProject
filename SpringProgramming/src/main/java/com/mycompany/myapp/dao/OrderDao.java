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

@Component
public class OrderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	   public Integer insert(Order order) {
		      Integer pk = null;
		      String sql = "insert into orders(order_date, order_payment, order_price, member_id) values(now(), ?, ?, ?)";
		      KeyHolder keyHolder = new GeneratedKeyHolder();
		      jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"order_no"});
				      pstmt.setString(1, order.getPayment());
				      pstmt.setInt(2, order.getPrice());
				      pstmt.setString(3, order.getId());
					return pstmt;
				}
		    	  
		      }, keyHolder);
		      Number keyNumber = keyHolder.getKey();
		      pk = keyNumber.intValue();
		      return pk;
		   }
		   
		   public Order selectByPk(int orderNo) {		     
		      String sql = "select*from orders where order_no=?";
		      Order order = jdbcTemplate.queryForObject(
		    		  sql, 
		    		  new Object[] {orderNo}, 
		    		  new RowMapper<Order>(){

						@Override
						public Order mapRow(ResultSet rs, int rowNo) throws SQLException {
							Order order = new Order();
							
							order.setNo(rs.getInt("order_no"));
					        order.setDate(rs.getDate("order_date"));
					        order.setPayment(rs.getString("order_payment"));
					        order.setPrice(rs.getInt("order_price"));
					        order.setId(rs.getString("member_id"));					              
					        
							return order;
						}
		    		 }
		    	);		     
		        
		      return order;
		   }
		   
			public List <Order> selectById (String member_id) {
			     String sql = "select * from orders where member_id = ?";
			          
			     List<Order> list = jdbcTemplate.query(
			    		 sql,
			    		 new Object[] {member_id},
			    		 new RowMapper<Order>() {

							@Override
							public Order mapRow(ResultSet rs, int arg1) throws SQLException {
								Order order = new Order();
								order.setNo(rs.getInt("order_no"));
								order.setDate(rs.getDate("order_date"));
								order.setPayment(rs.getString("order_payment"));
								order.setId(rs.getString("member_id"));
								order.setPrice(rs.getInt("order_price"));
								return order;
							}			    			 
			    		 }			    		 
			    	);
			     	return list;
			    }
			
			public List<Order> selectByPage(String member_id, int rownum, int rowPerPage) {				
				String sql = ""
						+ "select order_date, order_no, order_price, order_payment "						
						+ "from orders "
						+ "where member_id= ? "						
						+ "order by order_no desc "
						+ "limit ?, ?";
				
				List<Order> list = jdbcTemplate.query(
						sql,
						new Object[] { member_id, (rownum-1)*rowPerPage, rowPerPage},
						new RowMapper<Order>(){

							@Override
							public Order mapRow(ResultSet rs, int rowNo) throws SQLException {
								Order order = new Order();
								order.setDate(rs.getDate("order_date"));
								order.setNo(rs.getInt("order_no"));
								order.setPrice(rs.getInt("order_price"));
								order.setPayment(rs.getString("order_payment"));								
								
								return order;
							}						
						});
					return list;
				}
			
			public int selectCount(){
				String sql = "select count(*) from orders";
				int rows = jdbcTemplate.queryForObject(sql, Integer.class);
				return rows;
			}
}
			    		 
			   
