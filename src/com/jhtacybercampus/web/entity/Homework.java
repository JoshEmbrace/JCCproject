package com.jhtacybercampus.web.entity;

public class Homework {

	private int id;
	private String title;
	private String regDate;
	private String deadLine;
	
	

	public Homework(int id, String title, String regDate, String deadLine) {
		super();
		this.id = id;
		this.title = title;
		this.regDate = regDate;
		this.deadLine = deadLine;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the regDate
	 */
	public String getRegDate() {
		return regDate;
	}
	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	/**
	 * @return the deadLine
	 */
	public String getDeadLine() {
		return deadLine;
	}
	/**
	 * @param deadLine the deadLine to set
	 */
	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
	
	
	
}
