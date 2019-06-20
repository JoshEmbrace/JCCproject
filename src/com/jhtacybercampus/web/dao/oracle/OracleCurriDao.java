package com.jhtacybercampus.web.dao.oracle;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jhtacybercampus.web.dao.CurriDao;
import com.jhtacybercampus.web.entity.Curri;

public class OracleCurriDao implements CurriDao {
	
	public List<Curri> getList() throws ClassNotFoundException, SQLException {
		return getList(1);
	}
	@Override
	public List<Curri> getList(int page) throws ClassNotFoundException, SQLException {
	
		int start = 1 + (page - 1) * 10; // 1, 11, 21, 31, 41...
		int end = page * 10; // 10, 20, 30, 40, ...

		String sql = "SELECT * FROM curri_view WHERE NUM BETWEEN ? AND ?";
		
		String userId = "\"JCC\"";
		String pwd = "1234";
		List<Curri> curri = new ArrayList<>();
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, userId, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, start);
		st.setInt(2, end);

		ResultSet rs =st.executeQuery();
		
		while(rs.next()) {
			Curri cur = new Curri(
					rs.getInt("id"),
					rs.getString("title"), 
					rs.getString("content"), 
					rs.getString("writer_id"), 
					rs.getString("file_name"), 
					rs.getString("file_path"),
					rs.getString("reg_date")
					);
			
			curri.add(cur);
			
		}
		
		rs.close();
		st.close();
		con.close();
		return curri;
		
	}

	@Override
	public int update(Curri curri) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		String userId = "\"JCC\"";
		String pwd = "1234";
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, userId, pwd);
		
		String sql = "update curri set title=?, content=? where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, curri.getTitle());
		st.setString(2, curri.getContent());
		st.setInt(3, curri.getId());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}


	@Override
	public int insert(Curri curri) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		String userId = "\"JCC\"";
		String pwd = "1234";
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, userId, pwd);

		String sql = "insert into curri(id,title,content,writer_id) "
				+ "values(CURRI_SEQ.nextval,?,?,'bbdb')";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, curri.getTitle());
		st.setString(2, curri.getContent());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		String userId = "\"JCC\"";
		String pwd = "1234";
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, userId, pwd);
		
		String sql = "DELETE FROM CURRI WHERE ID="+id;
		Statement st = con.createStatement();
		result = st.executeUpdate(sql);
		
		st.close();
		con.close();
		
		return result;
	}

	@Override
	public Curri get(int id) throws ClassNotFoundException, SQLException {
		
		Curri curri = null;
		String userId = "\"JCC\"";
		String pwd = "1234";
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, userId, pwd);
		
		String sql = "SELECT * FROM CURRI WHERE ID =" + id;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if (rs.next()) {
			Curri cur = new Curri(
					rs.getInt("id"),
					rs.getString("title"), 
					rs.getString("content"), 
					rs.getString("writer_id"), 
					rs.getString("file_name"), 
					rs.getString("file_path"),
					rs.getString("reg_date")
					);
		}
		
		rs.close();
		st.close();
		con.close();

		return curri;
	}


}
