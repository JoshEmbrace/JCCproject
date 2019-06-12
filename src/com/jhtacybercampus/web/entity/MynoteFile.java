package com.jhtacybercampus.web.entity;

public class MynoteFile {
	 
	private int id;
	private String name;
	private int mynoteId;
	
	public MynoteFile() {
	}
	
	//for inserting
	public MynoteFile(String name, int mynoteId) {
		this.name = name;
		this.mynoteId = mynoteId;
	}
	
	
	//for selecting
	public MynoteFile(int id, String name, int mynoteId) {
		this.id = id;
		this.name = name;
		this.mynoteId = mynoteId;
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
	public int getMynoteId() {
		return mynoteId;
	}
	public void setMynoteId(int MynoteId) {
		this.mynoteId = mynoteId;
	}
}

	 

