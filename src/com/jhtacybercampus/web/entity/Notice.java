package com.jhtacybercampus.web.entity;

import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private String content;
	private String regDate;
	private String file_name;
	private String file_path;
	private int hit;
	private String writerId;
	
	public Notice() {
		
	}
	
	public Notice(int id, String title, String content, String regDate, String file_name, String file_path, int hit, String writerId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.file_name = file_name;
		this.file_path = file_path;
		this.hit = hit;
		this.writerId = writerId;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	
	
}
