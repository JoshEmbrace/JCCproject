package com.jhtacybercampus.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.jhtacybercampus.web.entity.Mynote;


public interface MynoteDao {
	List<Mynote> getList() throws ClassNotFoundException, SQLException;	
	
	
	int insert(Mynote mynote) throws ClassNotFoundException, SQLException;
	int update(Mynote mynote) throws ClassNotFoundException, SQLException;
	int delete(int id) throws SQLException, ClassNotFoundException;


	Mynote get(int id) throws ClassNotFoundException, SQLException;


	//int getLastId();



}
