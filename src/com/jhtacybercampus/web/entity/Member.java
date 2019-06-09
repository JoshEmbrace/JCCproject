package com.jhtacybercampus.web.entity;

import java.sql.Date;

public class Member {
	
	private int id;
	private String name;
	private int grade;
	private String email;
	private String hp;
	private String account;
	private int gender;
	private Date birthday;
	private String profile_img;
	private String user_id;
	
	
	public Member(int id, String name, int grade, String email, String hp, String account, int gender, Date birthday,
			String profile_img, String user_id) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.email = email;
		this.hp = hp;
		this.account = account;
		this.gender = gender;
		this.birthday = birthday;
		this.profile_img = profile_img;
		this.user_id = user_id;
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


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getHp() {
		return hp;
	}


	public void setHp(String hp) {
		this.hp = hp;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getProfile_img() {
		return profile_img;
	}


	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
	
	
	
	
	
}
