package com.jhtacybercampus.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.jhtacybercampus.web.entity.FreeBoard;
import com.jhtacybercampus.web.entity.FreeboardFile;

public interface FreeboardFileDao {
	List<FreeboardFile> getListByNoticeId(int freeboardId) throws ClassNotFoundException, SQLException, SQLException;
    
    int insert(FreeboardFile freeboardFile) throws ClassNotFoundException, SQLException;
    int update(FreeboardFile freeboardFile) throws ClassNotFoundException, SQLException;
    int delete(int id) throws ClassNotFoundException, SQLException;

}
