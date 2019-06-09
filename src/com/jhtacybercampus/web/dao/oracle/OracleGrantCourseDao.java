package com.jhtacybercampus.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jhtacybercampus.web.entity.GrantCourse;

public class OracleGrantCourseDao {
	
	public int getCount(int course_id) throws ClassNotFoundException, SQLException{
		
		int count=0;
		
		String sql = "select count(*) count from grant_course_view where course_id = "+course_id;
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next())
			count = rs.getInt("count");
		
		rs.close();
		st.close();
		con.close();
		return count;
	}
	
	public List<GrantCourse> getList() throws ClassNotFoundException, SQLException{
		
		List<GrantCourse> members = new ArrayList<>();
		GrantCourse member;
		
		String sql = "select *from grant_course_view";
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			
			member = new GrantCourse(
					rs.getInt("course_id"),
					rs.getString("course_name"),
					rs.getInt("member_id"),
					rs.getString("member_name")
					);
			members.add(member);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return members;
	}

	public List<GrantCourse> getList(int course_id) throws ClassNotFoundException, SQLException{
		
		List<GrantCourse> members = new ArrayList<>();
		GrantCourse member;
		
		String sql = "select *from grant_course_view where course_id="+course_id;
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			
			member = new GrantCourse(
					rs.getInt("course_id"),
					rs.getString("course_name"),
					rs.getInt("member_id"),
					rs.getString("member_name")
					);
			members.add(member);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return members;
	}
	
	public int delete(GrantCourse member) throws ClassNotFoundException, SQLException {
		
		String sql = "delete from grant_course where course_id = ?, member_id = ?";
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		int result = st.executeUpdate();
	
		st.close();
		con.close();
		
		return result;
	}
	
}
