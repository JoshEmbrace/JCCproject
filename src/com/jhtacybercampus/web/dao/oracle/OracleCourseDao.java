package com.jhtacybercampus.web.dao.oracle;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.jhtacybercampus.web.entity.Course;

public class OracleCourseDao {
	public List<Course> getList() throws ClassNotFoundException, SQLException {
		List<Course> list = new ArrayList<>();
		Course course=null;
		
		String sql = String.format("select *from course");
		String url = "jdbc:oracle:thin:@192.168.0.4:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while(rs.next()) {
			course = new Course(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("teacher"),
					rs.getString("manager"),
					rs.getString("open_date"),
					rs.getString("end_date"),
					rs.getString("writer_id"),
					rs.getInt("total")
					);
			list.add(course);
		}
		rs.close();
		st.close();
		con.close();

	
		 
		
		return list;
	}
	public Course get(int id) throws ClassNotFoundException, SQLException {

		Course course=null;
		
		String sql = String.format("select *from course where id=%d",id);
		String url = "jdbc:oracle:thin:@192.168.0.4:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		if(rs.next()) {
			course = new Course(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("teacher"),
					rs.getString("manager"),
					rs.getString("open_date"),
					rs.getString("end_date"),
					rs.getString("writer_id"),
					rs.getInt("total")
					);
		}
		rs.close();
		st.close();
		con.close();

		
		
		
		return course;
	}
	public int insert(Course course) throws ClassNotFoundException, SQLException {
		
		
		int result =0;
		
		String sql = "insert into course "
				+ "values(course_seq.nextval,?,?,?,?,?,'³²Áö¼÷',?)";
		String url = "jdbc:oracle:thin:@192.168.0.4:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,course.getName());
		st.setString(2,course.getTeacher());
		st.setString(3,course.getManager());
		st.setString(4, course.getOpenDate());
		st.setString(5, course.getEndDate());
		//st.setDate(4, (java.sql.Date)course.getOpenDate());
		//st.setDate(5, (java.sql.Date)course.getEndDate());
		st.setInt(6,course.getTotal());
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int result =0;
		
		String sql = String.format("delete from course where id=%d",id);
		String url = "jdbc:oracle:thin:@192.168.0.4:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		Statement st = con.createStatement();
		result = st.executeUpdate(sql);
		
		st.close();
		con.close();
		
		return result;
	}
	
	
	public int update(Course course) throws ClassNotFoundException, SQLException {
		int result =0;
		
		String sql = "update course set name=?,teacher=?,manager=?,"
				+ "open_date=?, end_date=? where id="+course.getId();
		String url = "jdbc:oracle:thin:@192.168.0.4:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,course.getName());
		st.setString(2,course.getTeacher());
		st.setString(3,course.getManager());
		st.setString(4, course.getOpenDate());
		st.setString(5, course.getEndDate());
		
		
		//st.setDate(4, course.getOpenDate());
		//st.setDate(5, course.getEndDate());
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
}
