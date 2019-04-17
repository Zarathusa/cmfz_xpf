package com.xpf.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Counter implements Serializable{

	private Integer id;
	private String title;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date last_date;
	private Integer count;
	public Counter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Counter(Integer id, String title, Date last_date, Integer count) {
		super();
		this.id = id;
		this.title = title;
		this.last_date = last_date;
		this.count = count;
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
	public Date getLast_date() {
		return last_date;
	}
	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Counter [id=" + id + ", title=" + title + ", last_date="
				+ last_date + ", count=" + count + "]";
	}
	
	
}
