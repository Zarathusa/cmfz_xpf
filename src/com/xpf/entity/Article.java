package com.xpf.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Article implements Serializable{

	private Integer id;
	private String title;
	private String author;
	private String insert_img;
	private String content;
	@JSONField(format="yyyy-MM-dd")
	private Date pub_date;
	private Guru guru;
	public Article() {
		super();
 	}
	public Article(Integer id, String title, String author, String insert_img,
			String content, Date pub_date, Guru guru) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.insert_img = insert_img;
		this.content = content;
		this.pub_date = pub_date;
		this.guru = guru;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getInsert_img() {
		return insert_img;
	}
	public void setInsert_img(String insert_img) {
		this.insert_img = insert_img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPub_date() {
		return pub_date;
	}
	public void setPub_date(Date pub_date) {
		this.pub_date = pub_date;
	}
	public Guru getGuru() {
		return guru;
	}
	public void setGuru(Guru guru) {
		this.guru = guru;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author
				+ ", insert_img=" + insert_img + ", content=" + content
				+ ", pub_date=" + pub_date + ", guru=" + guru + "]";
	}
	
}
