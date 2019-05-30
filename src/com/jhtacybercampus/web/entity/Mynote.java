package com.jhtacybercampus.web.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mynote {
	private int id;
	private String content;
	private String file_name;
	private String file_path;
	private Date reg_date;
	private String writer_id;
	
	public Mynote() {
		
	}

	public Mynote(int id, String content, String file_name, String file_path, Date reg_date, String writer_id) {
		
		this.id = id;
		this.content = content;
		this.file_name = file_name;
		this.file_path = file_path;
		this.reg_date = reg_date;
		this.writer_id = writer_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	
	
}



