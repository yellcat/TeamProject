package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Member;

@Component
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insert(Member member) {
		String sql = ""
				+ "insert into members "
				+ "(member_id, member_pw, member_name, member_mobile, member_address) "
				+ "values(?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException  {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPw());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getMobile());
				pstmt.setString(5, member.getAddress());
				return pstmt;
			}
		});
	}

/*	public List<Member> selectByPage(int pageNo, int rowsPerPage)  {
		String sql = ""
				+ "select member_no, member_title, member_writer, member_date, member_hitcount, member_original_file_name, member_filesystem_name, member_content_type "
				+ "from members " + "order by member_no desc " + "limit ?, ?";
		
		List<Member> list = jdbcTemplate.query(
			sql, 
			new Object[] {(pageNo-1)*rowsPerPage, rowsPerPage},
			new RowMapper<Member>() { //익명객체
				@Override
				public Member mapRow(ResultSet rs, int rowNum) throws SQLException  {
					Member member = new Member();
					member.setId(rs.getString("member_id"));
					member.setPw(rs.getString("member_pw"));
					member.setName(rs.getString("member_name"));
					member.setMobile(rs.getString("member_mobile"));
					member.setAddress(rs.getString("member_address"));
					return member;
				}
			}
		);
		return list;
	}*/
	
	public Member selectById(String memberId)  {
		
		String sql = "select * from members where member_no = ?";
		Member member = jdbcTemplate.queryForObject(
				sql,
				new Object[]{memberId},
				new RowMapper<Member>(){
					
					@Override
					public Member mapRow(ResultSet rs, int rowNo) throws SQLException  {
						Member member = new Member();
						member.setId(rs.getString("member_id"));
						member.setPw(rs.getString("member_pw"));
						member.setName(rs.getString("member_name"));
						member.setMobile(rs.getString("member_mobile"));
						member.setAddress(rs.getString("member_address"));
						return member;
					}				
				}
			);
		return member;
	}

	public int delete(String memberId)  {
		String sql = "delete from members where member_id = ?";
		int rows = jdbcTemplate.update(sql, memberId);
		return rows;
	}
	
}
