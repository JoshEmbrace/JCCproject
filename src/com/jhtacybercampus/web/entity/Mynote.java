package com.jhtacybercampus.web.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mynote {
	private int id;
	private String content;
	private Date reg_date;
	private int writer_id;
	
	public Mynote() {
		
	}

	public Mynote(int id, String content, Date reg_date, int writer_id) {
		
		this.id = id;
		this.content = content;
		this.reg_date = reg_date;
		this.writer_id = writer_id;
	}



	public Mynote(int id, String content, Date reg_date) {
		super();
		this.id = id;
		this.content = content;
		this.reg_date = reg_date;
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

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(int writer_id) {
		this.writer_id = writer_id;
	}


}



