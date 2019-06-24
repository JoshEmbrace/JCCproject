package com.jhtacybercampus.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
					rs.getString("birthday"),
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
					rs.getString("birthday"),
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
					rs.getString("birthday"),
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
					rs.getString("birthday"),
					"",
					rs.getString("user_id"),
					rs.getString("user_pwd")
					);
			Manager.add(member);
		}
		
		return Manager;
	}

	@Override
	public Member get(String User_id) throws ClassNotFoundException, SQLException {
		Member member = null;
		
		String sql = "select * from member where id="+User_id;
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
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
					rs.getString("birthday"),
					rs.getString("profilr_img"),
					rs.getString("user_id"),
					rs.getString("user_pwd")
					);
		}
		rs.close();
		st.close();
		con.close();
		
		return member;
	}

	@Override
	public int insert(Member member) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		String sql = "insert into member(id,name,grade,user_id,user_pwd)"+
					"values(member_seq.nextval,?,1,?,?)";
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, member.getName());
		st.setString(2, member.getUser_id());
		st.setString(3, member.getUser_pwd());
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	@Override
	public int update(Member member) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		String user_id = member.getUser_id();
		
		String sql = "update member set email=?, hp=?, account=?, profile_img=?, user_pwd=? where id="+user_id;
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");		
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, member.getEmail());
		st.setString(2, member.getHp());
		st.setString(3, member.getAccount());
		st.setString(4, member.getProfile_img());
		st.setString(5, member.getUser_pwd());
		
		result = st.executeUpdate();
		
		return result;
	}

	@Override
	public int delete(String id) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		String sql = "delete member where id=?";
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"JCC\"", "1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}


}
