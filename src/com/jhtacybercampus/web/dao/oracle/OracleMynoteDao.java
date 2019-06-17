package com.jhtacybercampus.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jhtacybercampus.web.dao.MynoteDao;
import com.jhtacybercampus.web.entity.Mynote;

public class OracleMynoteDao implements MynoteDao {
	@Override
	public List<MynoteView> getList() throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		return getList(1);
	}

	@Override
	public List<MynoteView> getList(int page) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		return getList(page,"content","");
	}

	@Override
	public List<MynoteView> getList(int page, String field, String query) throws  ClassNotFoundException, SQLException{
		List<MynoteView> list = new ArrayList<>();
		
		int pageSize = 10;
		int start = 1+(page-1)*pageSize;  //1,11,21,31,41...1+(page-1)*10
		int end = page * pageSize; 			//10,20,30.40,50
		
		String sql ="SELECT * FROM MYNOTE_VIEW" + 
				" WHERE "+field+" LIKE ? AND NUM BETWEEN ? and ?";
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,"%"+query+"%");
		st.setInt(2,start);
		st.setInt(3,end);
		
		//Standard JDK 
		
		//트렌젝션 처리 위해--> EJB 사용 -->SE 까지 쓰다가 스프링으로 넘어감 
		//EJB서버에 내가만든DAO 적재하고..과거에사용했던복잡어려운방법  -->스프링라이브러리사용
		
		
		
		con.setAutoCommit(false);
		
		ResultSet rs = st.executeQuery(); //꺼내오기
		
		con.commit();
		
		
		while (rs.next()) {
			MynoteView notice = new MynoteView(
				rs.getInt("id"),
				rs.getString("content"),
				rs.getDate("reg_date"),
				rs.getString("filename"),
				rs.getInt("fileid")
				);
			list.add(notice);
		}
	
		rs.close();
		st.close();
		con.close();
		
		return list;
		
	}
	
	
	

	
	@Override
	public int insert(Mynote mynote) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		String sql = "INSERT INTO MYNOTE(ID, CONTENT, REG_DATE, WRITER_ID)"
				+"VALUES(MYNOTE_SEQ.nextval,?,SYSDATE,\'작성자 : 해당계정\')";
		
//쿼리를 미리 짜놓고 값들을 나중에 넣어줘
//다른거는 쿼리를 만들 때 값을 넣으면서 만드는 것
		
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, mynote.getContent());

		result = st.executeUpdate(); //삽입,삭제
		
		st.close();
		con.close();

		return result;
	}
	

	@Override
	public int update(Mynote mynote) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		String sql = "UPDATE MYNOTE SET CONTENT=?, "
				+ "WHERE ID=?";
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		  PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, mynote.getContent());
			st.setInt(2, mynote.getId());

			result = st.executeUpdate(); //삽입,삭제
	      
			
			con.close();
		    st.close();
		    
		return result;
	} 
		
	
	@Override
	public int delete(int id) throws SQLException, ClassNotFoundException {
		int result = 0;
		
		String sql = "DELETE MYNOTE WHERE ID=?";
				
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
	      PreparedStatement st = con.prepareStatement(sql);
	      st.setInt(1, id);
	      result = st.executeUpdate();// 연동된 DB에 입력하기
	      
	      st.close();
	      con.close();

	      return result;
	}


	@Override
	public Mynote get(int id) throws ClassNotFoundException, SQLException {
		
		Mynote mynote = null;
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		String sql ="SELECT * FROM MYNOTE WHERE ID =" + id;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
			mynote = new Mynote(
					rs.getInt("ID"),
					rs.getString("content"),
					rs.getTimestamp("REG_DATE"),
					rs.getString("WRITER_ID")
					);
			
		}
	
		rs.close();
		st.close();
		con.close();
		
		return mynote;
	}


	@Override
	public int getLastId() throws ClassNotFoundException, SQLException {
	int id = -1;
		
		String sql = "SELECT ID FROM (SELECT * FROM MYNOTE ORDER BY REG_DATE DESC) WHERE ROWNUM = 1";
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); //삽입,삭제
	    
		 if (rs.next()) {
	         id=rs.getInt("id");
	      }
		
		rs.close();
	    st.close();
	    con.close();

	    return id;
	}


}	
