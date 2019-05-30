package com.jhtacybercampus.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleMemberDao {
	public List<String> getTeacher() throws ClassNotFoundException, SQLException {
		List<String> teacher = new ArrayList<>();
		String sql = "select name from member where grade=2";
		String url = "jdbc:oracle:thin:@192.168.0.4:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			String name = rs.getString("name");
			teacher.add(name);
		}
		
		return teacher;
	}
	public List<String> getManager() throws ClassNotFoundException, SQLException {
		List<String> manager = new ArrayList<>();
		String sql = "select name from member where grade=3";
		String url = "jdbc:oracle:thin:@192.168.0.4:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			String name = rs.getString("name");
			manager.add(name);
		}
		
		return manager;
	}
}
