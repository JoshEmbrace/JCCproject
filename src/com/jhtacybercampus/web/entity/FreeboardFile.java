package com.jhtacybercampus.web.entity;

public class FreeboardFile {
	
	private int id;
	private String name;
	private int freeboardId;
	
	
	public FreeboardFile() {
		
		
		
	}
	
	public FreeboardFile(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public FreeboardFile(int id, String name, int freeboardId) {
		this.id = id;
		this.name = name;
		this.freeboardId = freeboardId;
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
	public int getFreeboardId() {
		return freeboardId;
	}
	public void setFreeboardId(int freeboardId) {
		this.freeboardId = freeboardId;
	}
	

}
