package com.jhtacybercampus.web.entity;

public class GrantCourse {
	private int course_id;
	private String course_name;
	private int member_id;
	private String member_name;
	
	public GrantCourse() {
		
	}
	
	public GrantCourse(int course_id, String course_name, int member_id, String member_name) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.member_id = member_id;
		this.member_name = member_name;
	}
	
	
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	
	
}
