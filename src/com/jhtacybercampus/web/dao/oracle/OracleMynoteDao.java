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
import com.jhtacybercampus.web.entity.MynoteView;
import com.jhtacybercampus.web.entity.Notice;

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
		
		//Ʈ������ ó�� ����--> EJB ��� -->SE ���� ���ٰ� ���������� �Ѿ 
		//EJB������ ��������DAO �����ϰ�..���ſ�����ߴ�����������  -->���������̺귯�����
		
		
		
		con.setAutoCommit(false);
		
		ResultSet rs = st.executeQuery(); //��������
		
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
				+"VALUES(MYNOTE_SEQ.nextval,?,SYSDATE,?)";
		
//������ �̸� ¥���� ������ ���߿� �־���
//�ٸ��Ŵ� ������ ���� �� ���� �����鼭 ����� ��
		
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, mynote.getContent());
		st.setInt(2, mynote.getWriter_id());

		result = st.executeUpdate(); //����,����
		
		st.close();
		con.close();

		return result;
	}
	

	@Override
	public int update(Mynote mynote) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		String sql = "UPDATE MYNOTE SET CONTENT=? "
				+ "WHERE ID=?";
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		  PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, mynote.getContent());
			st.setInt(2, mynote.getId());

			result = st.executeUpdate(); //����,����
	      
			
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
	      result = st.executeUpdate();// ������ DB�� �Է��ϱ�
	      
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
					rs.getInt("WRITER_ID")
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
		ResultSet rs = st.executeQuery(sql); //����,����
	    
		 if (rs.next()) {
	         id=rs.getInt("id");
	      }
		
		rs.close();
	    st.close();
	    con.close();

	    return id;
	}


}	
