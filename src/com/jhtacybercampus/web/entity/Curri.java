package com.jhtacybercampus.web.entity;

import java.sql.Date;

public class Curri {

	private int id;
	private String title;
	private String content;
	private String writer_id;
	private String file_name;
	private String file_path;
	private String reg_date;
	
	public Curri() {

	}
	
	public Curri(int id, String title, String content, String writer_id, String file_name, String file_path,
			String reg_date) {

		this.id = id;
		this.title = title;
		this.content = content;
		this.writer_id = writer_id;
		this.file_name = file_name;
		this.file_path = file_path;
		this.reg_date = reg_date;
		
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

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	
	
}
