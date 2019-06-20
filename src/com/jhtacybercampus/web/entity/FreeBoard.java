package com.jhtacybercampus.web.entity;

import java.sql.Date;

public class FreeBoard {
	
	private int id;
	private String title;
	private String content;
	private Date reg_date;
	private String file_path;
	private String file_name;
	private int hit;
	private int writer_id;
	
	
	public FreeBoard(int id, String title, String content, Date reg_date, int hit,
			int writer_id) {
		//String file_path, String file_name
		
		this.id = id;
		this.title = title;
		this.content = content;
		this.reg_date = reg_date;
		//this.file_path = file_path;
		//this.file_name = file_name;
		this.hit = hit;
		this.writer_id = writer_id;
	}

	
	public FreeBoard() {
		
		
	}
	

	
	
	public FreeBoard(String[] args) {
		this.id = Integer.parseInt(args[0]);
		this.title = args[1];
		this.content = args[2];
		this.reg_date = null;
		this.file_path =args[3];
		this.file_name = args[4];
		this.hit = Integer.parseInt(args[5]);
		this.writer_id =Integer.parseInt(args[6]);
	}

	public FreeBoard(int id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(int writer_id) {
		this.writer_id = writer_id;
	}

}
