package com.xpf.entity;

import java.io.Serializable;

public class Admin implements Serializable{

	private Integer id;
	private String username;
	private String password;
	private Integer level;
	public Admin() {
		super();
	}
	public Admin(Integer id, String username, String password, Integer level) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.level = level;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password="
				+ password + ", level=" + level + "]";
	}
	
	
}
