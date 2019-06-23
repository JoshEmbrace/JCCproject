package com.jhtacybercampus.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jhtacybercampus.web.dao.MemberDao;
import com.jhtacybercampus.web.entity.Member;


public class OracleMemberDao implements MemberDao{
	
	
	public Member get(int id) throws ClassNotFoundException, SQLException {
		
		Member member = null;
		
		String sql = "select * from member where id="+id;
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
			member = new Member(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getInt("grade"),
					rs.getString("email"),
					rs.getString("hp"),
					rs.getString("account"),
					rs.getInt("gender"),
					rs.getDate("birthday"),
					rs.getString("profile_img"),
					rs.getString("user_id"),
					rs.getString("user_pwd")
					);
		}
		
		return member;
	}
	
	public List<Member> getStudent() throws ClassNotFoundException, SQLException {
		List<Member> student = new ArrayList<>();
		Member member = null;
		String sql = "select * from member where grade=1";
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			member = new Member(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getInt("grade"),
					rs.getString("email"),
					rs.getString("hp"),
					rs.getString("account"),
					rs.getInt("gender"),
					rs.getDate("birthday"),
					"",
					rs.getString("user_id"),
					rs.getString("user_pwd")
					);
			student.add(member);
		}
		
		return student;
	}
	
	public List<Member> getTeacher() throws ClassNotFoundException, SQLException {
		List<Member> teacher = new ArrayList<>();
		Member member = null;
		String sql = "select * from member where grade=2";
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			member = new Member(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getInt("grade"),
					rs.getString("email"),
					rs.getString("hp"),
					rs.getString("account"),
					rs.getInt("gender"),
					rs.getDate("birthday"),
					"",
					rs.getString("user_id"),
					rs.getString("user_pwd")
					);
			teacher.add(member);
		}
		
		return teacher;
	}
	
	public List<Member> getManager() throws ClassNotFoundException, SQLException {
		List<Member> Manager = new ArrayList<>();
		Member member = null;
		String sql = "select * from member where grade=3";
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			member = new Member(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getInt("grade"),
					rs.getString("email"),
					rs.getString("hp"),
					rs.getString("account"),
					rs.getInt("gender"),
					rs.getDate("birthday"),
					"",
					rs.getString("user_id"),
					rs.getString("user_pwd")
					);
			Manager.add(member);
		}
		
		return Manager;
	}

	@Override
	public Member get(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Member member) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Member member) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


}
