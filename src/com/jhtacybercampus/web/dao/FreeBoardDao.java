package com.jhtacybercampus.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.jhtacybercampus.web.entity.FreeBoard;


public interface FreeBoardDao {
	
	List<FreeBoard> getList()  throws ClassNotFoundException, SQLException;
	List<FreeBoard> getList(int page)  throws ClassNotFoundException, SQLException;
	List<FreeBoard> getList(int page, String field, String query) throws ClassNotFoundException, SQLException;
	
	
	FreeBoard get(int id) throws ClassNotFoundException, SQLException; //FreeBoard의 아이디를 얻어온다. 
	FreeBoard getPrev(int id) throws ClassNotFoundException, SQLException;
	FreeBoard getNext(int id) throws ClassNotFoundException, SQLException;
	
	int insert(FreeBoard freeB) throws ClassNotFoundException, SQLException;
	int update(FreeBoard freeB) throws ClassNotFoundException, SQLException;
	int delete(int id) throws ClassNotFoundException, SQLException;
	

}



								