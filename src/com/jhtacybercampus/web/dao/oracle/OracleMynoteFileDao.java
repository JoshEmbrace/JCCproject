package com.jhtacybercampus.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jhtacybercampus.web.dao.MynoteFileDao;
import com.jhtacybercampus.web.entity.MynoteFile;



public class OracleMynoteFileDao implements MynoteFileDao {


@Override
public List<MynoteFile> getListByMynoteId(int mynoteId) throws ClassNotFoundException, SQLException {
	List<MynoteFile> list = new ArrayList<>();
	
	
	String sql ="SELECT * FROM MYNOTE_FILE WHERE MYNOTE_ID=?";
	
	String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
	PreparedStatement st = con.prepareStatement(sql);
	
	
	st.setInt(1,mynoteId);

	ResultSet rs = st.executeQuery(); //꺼내오기


	while (rs.next()) {
		MynoteFile mynoteFile = new MynoteFile(
			rs.getInt("id"),
			rs.getString("name"),
			rs.getInt("mynote_id")
			);
		list.add(mynoteFile);
	}
	
	
	rs.close();
	st.close();
	con.close();
	
	return list;
	
}

@Override
public int insert(MynoteFile mynoteFile) throws ClassNotFoundException, SQLException {
	 int result = 0;
     
     String sql = "INSERT INTO MYNOTE_FILE(ID, NAME, MYNOTE_ID) " 
      + "VALUES (MYNOTE_FILE_SEQ.NEXTVAL, ? ,?)";
     String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
    
     PreparedStatement st = con.prepareStatement(sql);
     st.setString(1, mynoteFile.getName());
     st.setInt(2, mynoteFile.getMynoteId());
     // st.setInt(3, notice.getId());
     /*
      * ResultSet a = st.executeQuery(sql); //만들어진 테이블 조회해서 가져오기
      */
     result = st.executeUpdate();// 연동된 DB에 입력하기

     st.close();
     con.close();

     return result;
  }


@Override
public int update(MynoteFile mynoteFile) throws ClassNotFoundException, SQLException {
	 int result = 0;

     String sql = "UPDATE MYNOTE_FILE SET NAME=?, MYNOTE_ID=? WHERE ID=?";

     String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");

     PreparedStatement st = con.prepareStatement(sql);
     st.setString(1, mynoteFile.getName());
     st.setInt(2, mynoteFile.getMynoteId());
     st.setInt(3, mynoteFile.getId());

     result = st.executeUpdate();

     st.close();
     con.close();

     return result;
  }

@Override
public int delete(int id) throws ClassNotFoundException, SQLException {
    int result = 0;

    String sql = "DELETE MYNOTE_FILE WHERE ID=?";

    String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");

    PreparedStatement st = con.prepareStatement(sql);
    st.setInt(1, id);

    result = st.executeUpdate();

    st.close();
    con.close();

    return result;
}

@Override
public int getLastId() throws ClassNotFoundException, SQLException {
	int id = -1;
	
	String sql = "SELECT ID FROM (SELECT * FROM MYNOTE ORDER BY REGDATE DESC) WHERE ROWNUM = 1";
	
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