package com.jhtacybercampus.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.jhtacybercampus.web.entity.NoticeFile;

public interface NoticeFileDao {
	List<NoticeFile> getListByNoticeId(int noticeId) throws ClassNotFoundException, SQLException;
	int insert(NoticeFile noticeFile) throws SQLException, ClassNotFoundException;
	int update(NoticeFile noticeFile) throws ClassNotFoundException, SQLException;
	int delete(int id) throws ClassNotFoundException, SQLException;
	int getLastId() throws ClassNotFoundException, SQLException;
}
