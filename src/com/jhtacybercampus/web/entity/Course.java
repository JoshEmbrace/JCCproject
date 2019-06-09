package com.jhtacybercampus.web.entity;

import java.util.Date;

public class Course {
	private int id;
	private String name;
	private int teacher_id;
	private int manager_id;
	private String open_date;
	private String end_date;
	private int writer_id;
	private int total;
	
	public Course() {
		
	}
	
	public Course(int id, String name, int teacher_id, int manager_id, String open_date, String end_date, int writer_id,
			int total) {
		super();
		this.id = id;
		this.name = name;
		this.teacher_id = teacher_id;
		this.manager_id = manager_id;
		this.open_date = open_date;
		this.end_date = end_date;
		this.writer_id = writer_id;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}


	public String getOpen_date() {
		return open_date;
	}

	public void setOpen_date(String open_date) {
		this.open_date = open_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(int writer_id) {
		this.writer_id = writer_id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
