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
	

	public FreeBoardView(int id, String title, String content, Date reg_date, String file_path, String file_name,
			int hit, String writer_id, int commentCount) {
		super(id, title, content, reg_date, file_path, file_name, hit, writer_id);
		this.commentCount = commentCount;
	
	}
	
	public FreeBoardView(String[] args) {
		super(args);
	
	}
	

}
