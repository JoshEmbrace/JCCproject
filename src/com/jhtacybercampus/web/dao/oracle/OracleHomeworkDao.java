package com.jhtacybercampus.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jhtacybercampus.web.entity.Homework;


public class OracleHomeworkDao {
	public List<Homework> getList() throws ClassNotFoundException, SQLException{
		return getList(1,"title","");
	}
	
	public List<Homework> getList(int page) throws ClassNotFoundException, SQLException{
		return getList(page,"title","");
	}
	
	public List<Homework> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		List<Homework> list = new ArrayList<>();
		Homework homework=null;
		
		String sql = "SELECT * FROM "
				+ "(select * from HOMEWORK order by reg_date) WHERE " + field + " LIKE ? AND NUM BETWEEN ? AND ?";
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
			homework = new Homework(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("reg_date"),
					rs.getString("deadline")
					);
			list.add(homework);
		}
		rs.close();
		st.close();
		con.close();


		return list;
	}
	
	public Homework get(int id) throws ClassNotFoundException, SQLException {

		Homework homework=null;
		
		String sql = String.format("select *from homework where id=%d",id);
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		if(rs.next()) {
			homework = new Homework(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("reg_date"),
					rs.getString("deadline")
					);
		}
		rs.close();
		st.close();
		con.close();

		return homework;
	}
	
	
	public int insert(Homework homework) throws ClassNotFoundException, SQLException{
		int result =0;
		
		return result;
	}
	
	public int update(Homework homework) throws ClassNotFoundException, SQLException{
		int result =0;
		
		return result;
	}
	
	public int delete(int id) throws ClassNotFoundException, SQLException{
		int result =0;
		
		return result;
	}
}
