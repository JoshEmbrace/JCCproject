package com.jhtacybercampus.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.jhtacybercampus.web.entity.Notice;

public interface NoticeDao {

	List<Notice> getList() throws ClassNotFoundException, SQLException;
	List<Notice> getList(int page) throws ClassNotFoundException, SQLException;
	List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException;
	
	Notice get(int id);
	Notice getPrev(int id);
	Notice getNext(int id);
	
	int insert(Notice notice) throws ClassNotFoundException, SQLException;
	int delete(int id) throws ClassNotFoundException, SQLException;
	int update(Notice notice) throws ClassNotFoundException, SQLException;
}
