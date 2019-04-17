package com.xpf.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class Task implements Serializable{

	private Integer id;
	private String title;
	private String mark;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date pub_date;
	private List<Counter> counters;
	private User user;
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(Integer id, String title, String mark, Date pub_date,
			List<Counter> counters, User user) {
		super();
		this.id = id;
		this.title = title;
		this.mark = mark;
		this.pub_date = pub_date;
		this.counters = counters;
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public Date getPub_date() {
		return pub_date;
	}
	public void setPub_date(Date pub_date) {
		this.pub_date = pub_date;
	}
	public List<Counter> getCounters() {
		return counters;
	}
	public void setCounters(List<Counter> counters) {
		this.counters = counters;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", mark=" + mark
				+ ", pub_date=" + pub_date + ", counters=" + counters
				+ ", user=" + user + "]";
	}
	
}
