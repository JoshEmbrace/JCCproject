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
import javax.print.attribute.standard.PresentationDirection;

import com.jhtacybercampus.web.entity.Course;
import com.jhtacybercampus.web.entity.CourseView;

public class OracleCourseDao {
	
	public List<CourseView> getList() throws ClassNotFoundException, SQLException{
		return getList(1,"name","");
	}
	
	public List<CourseView> getList(int page) throws ClassNotFoundException, SQLException{
		return getList(page,"name","");
	}
	
	public List<CourseView> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		List<CourseView> list = new ArrayList<>();
		CourseView course=null;
		
		String sql = "SELECT * FROM COURSE_VIEW WHERE " + field + " LIKE ? AND NUM BETWEEN ? AND ?";
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		
		
		int start = 1+(page-1)*15; //페이지 수 1, 11, 21, 31, 41....
		int end = page * 15;  //10, 20 , 30, 40 , ...																											
		
		
		st.setString(1, "%" + query + "%");                       
		st.setInt(2, start);
		st.setInt(3, end);
		ResultSet rs = st.executeQuery();

		
		while(rs.next()) {
			course = new CourseView(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("teacher"),
					rs.getString("manager"),
					rs.getString("open_date"),
					rs.getString("end_date"),
					rs.getString("writer"),
					rs.getInt("total")
					);
			list.add(course);
		}
		rs.close();
		st.close();
		con.close();


		return list;
	}
	
	public CourseView get(int id) throws ClassNotFoundException, SQLException {

		CourseView course=null;
		
		String sql = String.format("select *from course_view where id=%d",id);
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		if(rs.next()) {
			course = new CourseView(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("teacher"),
					rs.getString("manager"),
					rs.getString("open_date"),
					rs.getString("end_date"),
					rs.getString("writer"),
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
				+ "values(course_seq.nextval,?,?,?,?,?,7,?)";
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,course.getName());
		st.setInt(2,course.getTeacher_id());
		st.setInt(3,course.getManager_id());
		st.setString(4, course.getOpen_date());
		st.setString(5, course.getEnd_date());
		st.setInt(6,course.getTotal());
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int result =0;
		
		String sql = String.format("delete from course where id=%d",id);
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";

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
		
		String sql = "update course set name=?,teacher_id=?,manager_id=?,"
				+ "open_date=?, end_date=? where id="+course.getId();
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,course.getName());
		st.setInt(2,course.getTeacher_id());
		st.setInt(3,course.getManager_id());
		st.setString(4, course.getOpen_date());
		st.setString(5, course.getEnd_date());

		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	
}
