package com.jhtacybercampus.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.jhtacybercampus.web.entity.Member;

public interface MemberDao {

	Member get(String id) throws ClassNotFoundException, SQLException;
	List<Member> getStudent() throws ClassNotFoundException, SQLException;
	List<Member> getTeacher() throws ClassNotFoundException, SQLException;
	List<Member> getManager() throws ClassNotFoundException, SQLException;
	int insert(Member member) throws ClassNotFoundException, SQLException;
	int update(Member member) throws ClassNotFoundException, SQLException;

	int delete(String id) throws ClassNotFoundException, SQLException;

	

	
} 
