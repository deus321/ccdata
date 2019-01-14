package com.deus.store.domain;

import java.util.Date;

public class User {
	private String uid;
	private String username;
	private String name;
	private String password;
	private String email;
	private String sex;
	private String telephone;
	private Date birthday;
	private int state;
	private String code;
	public String getUid() {
		return uid;
	}
	public String getUsername() {
		return username;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getSex() {
		return sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public int getState() {
		return state;
	}
	public String getCode() {
		return code;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
