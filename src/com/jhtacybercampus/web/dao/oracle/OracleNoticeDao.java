package com.jhtacybercampus.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jhtacybercampus.web.dao.NoticeDao;
import com.jhtacybercampus.web.entity.Notice;

public class OracleNoticeDao implements NoticeDao{

	@Override
	public List<Notice> getList() throws ClassNotFoundException, SQLException {
		return getList(1,"title","");
	}

	@Override
	public List<Notice> getList(int page) throws ClassNotFoundException, SQLException {
		return getList(page,"title","");
	}

	@Override
	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		
		List<Notice> list = new ArrayList<>();
		
		int start = 1+(page-1)*15;
		int end = page*15;
		
		String sql = "SELECT * FROM NOTICE_VIEW"+" WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		st.setInt(2, start);
		st.setInt(3, end);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			Notice notice = new Notice(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("reg_date"),
						rs.getString("file_name"),
						rs.getString("file_path"),
						rs.getInt("hit"),
						rs.getString("writer_id"));
			list.add(notice);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	@Override
	public Notice get(int id) {
		
		Notice notice = null;
		
		String sql = "select * from notice where id="+id;
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				notice = new Notice(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("reg_date"),
						rs.getString("file_name"),
						rs.getString("file_path"),
						rs.getInt("hit"),
						rs.getString("writer_id")
						);
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}

	@Override
	public Notice getPrev(int id) {
		Notice notice = null;
		
		String sql = "select * from notice_view where reg_date<(select regdate from notice where id="+id+") and rownum=1";
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				notice = new Notice(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("reg_date"),
						rs.getString("file_name"),
						rs.getString("file_path"),
						rs.getInt("hit"),
						rs.getString("writer_id")
						);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return notice;
	}

	@Override
	public Notice getNext(int id) {
		Notice notice = null;
		
		String sql = "select * from(select * from notice_view order by reg_date) where regdate > (select regdate from notice where id="+id+") and rownum =1";
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				notice = new Notice(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("reg_date"),
						rs.getString("file_name"),
						rs.getString("file_path"),
						rs.getInt("hit"),
						rs.getString("writer_id")
						);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return notice;
	}

	@Override
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		String sql = "insert into notice(id,title,content,writer_id)"+"values(notice_seq.nextval,?,?,'ÀåÇý¸®')";
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
		String sql = "delete notice where id=?";
		
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
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		int id = notice.getId();
		String sql = "update notice set title=?, content=? where id="+id;
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		return result;
	}

}
