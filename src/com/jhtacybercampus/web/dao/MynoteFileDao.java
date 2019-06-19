package com.jhtacybercampus.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.jhtacybercampus.web.entity.MynoteFile;


public interface MynoteFileDao {
	   List<MynoteFile> getListByMynoteId(int mynoteId) throws ClassNotFoundException, SQLException;
	       
	   int insert(MynoteFile mynoteFile) throws ClassNotFoundException, SQLException;
	   int update(MynoteFile mynoteFile) throws ClassNotFoundException, SQLException;
	   int delete(int id) throws ClassNotFoundException, SQLException;
	   int getLastId() throws ClassNotFoundException, SQLException;
	}