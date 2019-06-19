package com.jhtacybercampus.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.jhtacybercampus.web.dao.FreeBoardDao;
import com.jhtacybercampus.web.entity.FreeBoard;


public class OracleFreeBoardDao implements FreeBoardDao {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		OracleFreeBoardDao oo = new OracleFreeBoardDao();
		FreeBoard notice = new FreeBoard();
		notice.setContent("content");
		notice.setTitle("title");
		oo.insert(notice);
		System.out.println(oo.getList());

	}

	@Override
	public List<FreeBoard> getList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(1, "title", "");
	}


	@Override
	public List<FreeBoard> getList(int page) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(page, "title", "");
	}


	@Override
	public List<FreeBoard> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {  // FreeBoard(int id, String title, String writer_id) 
		List<FreeBoard> list = new ArrayList<>();
		FreeBoard fb = null;

		int start = 1+(page-1)*15; //페이지 수 1, 11, 21, 31, 41....
		int end = page * 15;  //10, 20 , 30, 40 , ...																											

		String sql = "SELECT * FROM FREEBOARD_VIEW WHERE " + field+ " LIKE ? AND NUM BETWEEN ? AND ?";


		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");


		//		String url = "jdbc:oracle:thin:@localhost:1522/XE";
		//		Class.forName("oracle.jdbc.driver.OracleDriver");
		//		Connection con = DriverManager.getConnection(url, "system", "1234");
		//		
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, "%" + query + "%");                       
		st.setInt(2, start);
		st.setInt(3, end);
		ResultSet rs  =st.executeQuery();

		while(rs.next()) {

			fb = new FreeBoard(				    
					rs.getInt("id"), 
					rs.getString("title"),
					rs.getString("content"),
					rs.getDate("reg_date"),
					" ",   //rs.getString("file_name"),
					" ",    // //rs.getString("file_path"),
					rs.getInt("hit"), 
					rs.getInt("writer_id")
					);

			list.add(fb);
			/* rs.getString("content"), 컨텐트가 없어서 가져오는 작업을 하면 오류가 난다 */
		}

		return list;
	}

	@Override
	public FreeBoard get(int id) throws ClassNotFoundException, SQLException {
		String sql = "select * from freeboard where id=?";
		FreeBoard fb = null;

		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");

		//		String url = "jdbc:oracle:thin:@localhost:1522/XE";
		//		Class.forName("oracle.jdbc.driver.OracleDriver");
		//		Connection con = DriverManager.getConnection(url, "system", "1234");

		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		ResultSet rs  =st.executeQuery();

		if(rs.next()) {
			fb = new FreeBoard(				
					rs.getInt("id"), 
					rs.getString("title"),
					rs.getString("content"),
					rs.getDate("reg_date"),
					rs.getString("file_path"),
					rs.getString("file_name"),
					rs.getInt("hit"), 
					rs.getInt("writer_id")
					);
		}

		rs.close();
		st.close();
		con.close();

		return fb;	
	}


	@Override
	public FreeBoard getPrev(int id)  throws ClassNotFoundException, SQLException {
		String sql = "select * from(select * from freeboard_view order by reg_date desc)" + "where reg_date < ( select reg_date from freeboard where id =" + id+ ")" + "and rownum =1";
		FreeBoard fb = null;

		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");

		//		String url = "jdbc:oracle:thin:@localhost:1522/XE";
		//		Class.forName("oracle.jdbc.driver.OracleDriver");
		//		Connection con = DriverManager.getConnection(url, "system", "1234");

		Statement st = con.createStatement();
		ResultSet rs  =st.executeQuery(sql);

		if(rs.next()) {
			fb = new FreeBoard(				
					rs.getInt("id"), 
					rs.getString("title"),
					rs.getString("content"),
					rs.getDate("reg_date"),
					rs.getString("file_path"),
					rs.getString("file_name"),
					rs.getInt("hit"), 
					rs.getInt("writer_id")
					);
		}

		rs.close();
		st.close();
		con.close();


		return fb;
	}

	@Override
	public FreeBoard getNext(int id)  throws ClassNotFoundException, SQLException {
		String sql ="select * from (select * from freeboard_view where reg_date >(select reg_date from freeboard where id =" + id + ")order by reg_date asc) where rownum = 1";

		FreeBoard fb = null;

		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");

		//		String url = "jdbc:oracle:thin:@localhost:1522/XE";
		//		Class.forName("oracle.jdbc.driver.OracleDriver");
		//		Connection con = DriverManager.getConnection(url, "system", "1234");

		Statement st = con.createStatement();
		ResultSet rs  =st.executeQuery(sql);

		if(rs.next()) {
			fb = new FreeBoard(				
					rs.getInt("id"), 
					rs.getString("title"),
					rs.getString("content"),
					rs.getDate("reg_date"),
					rs.getString("file_path"),
					rs.getString("file_name"),
					rs.getInt("hit"), 
					rs.getInt("writer_id")
					);
		}

		rs.close();
		st.close();
		con.close();

		return fb;
	}

	@Override
	public int insert(FreeBoard freeB)  throws ClassNotFoundException, SQLException {

		//결과가 몇 개인지 알아보기 위한 변수

		int result = 0;

		String sql ="insert into freeboard(id, title, content, writer_id) " + "values(FREEBOARD_SEQ.NEXTVAL,?,?,?)";

		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");

		//		String url = "jdbc:oracle:thin:@localhost:1522/XE";
		//		Class.forName("oracle.jdbc.driver.OracleDriver");
		//		Connection con = DriverManager.getConnection(url, "system", "1234");

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, freeB.getTitle());
		st.setString(2, freeB.getContent());
		st.setInt(3, freeB.getWriter_id());
		result = st.executeUpdate(); // 몇개를 옫었는지 정수값을 반환 ex)insert한 레코드 


		st.close();
		con.close();

		return result;
	}


	@Override
	public int update(FreeBoard freeB) throws ClassNotFoundException, SQLException {
		int result = 0;

		//String sql = "update notice set title='" + notice.getTitle() + "' where id = " + notice.getId(); 
		int id = freeB.getId();

		String sql = "update freeboard set title = ?, content = ? where id=?" ;		

		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		//				
		//		String url = "jdbc:oracle:thin:@localhost:1522/XE";
		//		Class.forName("oracle.jdbc.driver.OracleDriver");
		//		Connection con = DriverManager.getConnection(url, "system", "1234");

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, freeB.getTitle());
		st.setString(2, freeB.getContent());
		st.setInt(3, freeB.getId());


		result = st.executeUpdate(); // 몇개를 옫었는지 정수값을 반환 ex)insert한 레코드 

		st.close();
		con.close();
		return result ;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int result = 0;

		String sql = "delete freeboard where id =?";

		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		//		
		//		String url = "jdbc:oracle:thin:@localhost:1522/XE";
		//		Class.forName("oracle.jdbc.driver.OracleDriver");
		//		Connection con = DriverManager.getConnection(url, "system", "1234");

		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		ResultSet rs  =st.executeQuery();

		result = st.executeUpdate(sql); // 몇개를 옫었는지 정수값을 반환 ex)insert한 레코드 

		st.close();
		con.close();
		return result;
	}

	@Override
	public int getLastId() throws ClassNotFoundException, SQLException {
		int id = -1;
		String sql ="select * from (select * from freeboard order by reg_date desc) where rownum = 1";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");// Connection
		Statement st = con.createStatement();// Statement
		ResultSet rs = st.executeQuery(sql);// ResultSet
		if(rs.next())
			id = rs.getInt("id");

		rs.close();
		st.close();
		con.close();

		return id;
	}




}
