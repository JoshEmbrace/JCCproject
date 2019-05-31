package com.jhtacybercampus.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jhtacybercampus.web.dao.MynoteDao;
import com.jhtacybercampus.web.entity.Mynote;

public class OracleMynoteDao implements MynoteDao {

	@Override
	public List<Mynote> getList() throws ClassNotFoundException, SQLException {
		List<Mynote> mynote = new ArrayList<Mynote>();
		
		String url = "jdbc:oracle:thin:@192.168.0.4:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		String sql ="SELECT * FROM MYNOTE";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			Mynote note = new Mynote(
					rs.getInt("ID"),
					rs.getString("content"),
					rs.getString("FILE_NAME"),
					rs.getString("FILE_PATH"),
					rs.getTimestamp("REG_DATE"),
					rs.getString("WRITER_ID")
					);
			mynote.add(note);
		}
	
		rs.close();
		st.close();
		con.close();
		
		return mynote;
	}
	
	
	@Override
	public int insert(Mynote mynote) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		String url = "jdbc:oracle:thin:@192.168.0.4:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		String sql = "INSERT INTO MYNOTE(ID, CONTENT, FILE_NAME, FILE_PATH, WRITER_ID)"
				+"VALUES(MYNOTE_SEQ.nextval,?,?,?,\'작성자 : 해당계정\')";
		
//쿼리를 미리 짜놓고 값들을 나중에 넣어줘
//다른거는 쿼리를 만들 때 값을 넣으면서 만드는 것
		
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, mynote.getContent());
		st.setString(2, mynote.getFile_name());
		st.setString(3, mynote.getFile_path());

		result = st.executeUpdate(); //삽입,삭제
		
		st.close();
		con.close();

		return result;
	}
	

	@Override
	public int update(Mynote mynote) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		String sql = "UPDATE MYNOTE SET CONTENT=?, FILE_NAME=?,"
				+ "FILE_PATH=? WHRER ID=?";
		String url = "jdbc:oracle:thin:@192.168.0.4:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		  PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, mynote.getContent());
			st.setString(2, mynote.getFile_name());
			st.setString(3, mynote.getFile_path());
			st.setInt(4, mynote.getId());

			result = st.executeUpdate(); //삽입,삭제
	      
			
			con.close();
		    st.close();
		    
		return result;
	} 
		
	
	@Override
	public int delete(int id) throws SQLException, ClassNotFoundException {
		int result = 0;
		
		String sql = "DELETE MYNOTE WHERE ID=?";
				
		String url = "jdbc:oracle:thin:@192.168.0.4:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
	      PreparedStatement st = con.prepareStatement(sql);
	      st.setInt(1, id);
	      result = st.executeUpdate();// 연동된 DB에 입력하기
	      
	      st.close();
	      con.close();

	      return result;
	}
}	
