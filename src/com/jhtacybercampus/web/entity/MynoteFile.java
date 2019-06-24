package com.jhtacybercampus.web.entity;

public class MynoteFile {
	 
	private int id;
	private String filename;
	private int mynoteId;
	
	public MynoteFile() {
	}
	
	//for inserting
	public MynoteFile(String filename, int mynoteId) {
		this.filename = filename;
		this.mynoteId = mynoteId;
	}
	
	
	//for selecting
	public MynoteFile(int id, String filename, int mynoteId) {
		this.id = id;
		this.filename = filename;
		this.mynoteId = mynoteId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return filename;
	}
	public void setName(String filename) {
		this.filename = filename;
	}
	public int getMynoteId() {
		return mynoteId;
	}
	public void setMynoteId(int mynoteId) {
		this.mynoteId = mynoteId;
	}
}

	 

