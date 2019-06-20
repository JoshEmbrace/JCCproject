package com.jhtacybercampus.web.entity;

import java.sql.Date;

public class FreeBoardView extends FreeBoard{
	
	private int commentCount;

	
	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	
	public FreeBoardView() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//String file_path, String file_name,
	public FreeBoardView(int id, String title, String content, Date reg_date, 
			int hit, int writer_id, int commentCount) {
		super(id, title, content, reg_date,  hit, writer_id);
//		file_path, file_name,
		this.commentCount = commentCount;
	
	}
	
	public FreeBoardView(String[] args) {
		super(args);
	
	}
	

}
