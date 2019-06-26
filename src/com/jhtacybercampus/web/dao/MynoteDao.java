package com.jhtacybercampus.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.jhtacybercampus.web.entity.Mynote;
import com.jhtacybercampus.web.entity.MynoteView;


public interface MynoteDao {
	List<MynoteView> getList() throws ClassNotFoundException, SQLException;	
	
	
	int insert(Mynote mynote) throws ClassNotFoundException, SQLException;
	int update(Mynote mynote) throws ClassNotFoundException, SQLException;
	int delete(int id) throws SQLException, ClassNotFoundException;


	Mynote get(int id) throws ClassNotFoundException, SQLException;
	int getLastId() throws ClassNotFoundException, SQLException;
	List<MynoteView> getList(int page) throws ClassNotFoundException, SQLException;
	List<MynoteView> getList(int page, String field, String query) throws  ClassNotFoundException, SQLException;


}
