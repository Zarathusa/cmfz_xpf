package com.xpf.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Chapter implements Serializable{

	private Integer id;
	private String title;
	private String size;
	private String url;
	private String duration;
	@DateTimeFormat
	@JSONField(format="yyyy-MM-dd")
	private Date pub_date;
	private Album album;
	
	
	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Chapter(Integer id, String title, String size, String url,
			String duration, Date pub_date, Album album) {
		super();
		this.id = id;
		this.title = title;
		this.size = size;
		this.url = url;
		this.duration = duration;
		this.pub_date = pub_date;
		this.album = album;
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


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public Date getPub_date() {
		return pub_date;
	}


	public void setPub_date(Date pub_date) {
		this.pub_date = pub_date;
	}


	public Album getAlbum() {
		return album;
	}


	public void setAlbum(Album album) {
		this.album = album;
	}


	@Override
	public String toString() {
		return "Chapter [id=" + id + ", title=" + title + ", size=" + size
				+ ", url=" + url + ", duration=" + duration + ", pub_date="
				+ pub_date + ", album=" + album + "]";
	}
	
	
	
	
	
	
}
