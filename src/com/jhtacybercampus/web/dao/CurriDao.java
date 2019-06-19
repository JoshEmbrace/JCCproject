package com.jhtacybercampus.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.jhtacybercampus.web.entity.Curri;

public interface CurriDao {

	List<Curri> getList() throws ClassNotFoundException, SQLException;
	List<Curri> getList(int page) throws ClassNotFoundException, SQLException;

	Curri get(int id) throws ClassNotFoundException, SQLException;
	
	int delete(int id) throws ClassNotFoundException, SQLException;
	int update(Curri curri) throws ClassNotFoundException, SQLException;
	int insert(Curri curri) throws ClassNotFoundException, SQLException;


	
}
