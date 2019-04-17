package com.xpf.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Album implements Serializable{
	
	private Integer id;
	private String title;
	private Double score;
	private String author;
	private String img_path;
	private String beam;
	private Integer count;
	private String content;
	@DateTimeFormat
	@JSONField(format="yyyy-MM-dd")
	private Date pub_date;
	
	/**
	 * 集合必须是children 前端才能接收到
	 */
	private List<Chapter> children;

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Album(Integer id, String title, Double score, String author,
			String img_path, String beam, Integer count, String content,
			Date pub_date, List<Chapter> children) {
		super();
		this.id = id;
		this.title = title;
		this.score = score;
		this.author = author;
		this.img_path = img_path;
		this.beam = beam;
		this.count = count;
		this.content = content;
		this.pub_date = pub_date;
		this.children = children;
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

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public String getBeam() {
		return beam;
	}

	public void setBeam(String beam) {
		this.beam = beam;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
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

	public List<Chapter> getChildren() {
		return children;
	}

	public void setChildren(List<Chapter> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", score=" + score
				+ ", author=" + author + ", img_path=" + img_path + ", beam="
				+ beam + ", count=" + count + ", content=" + content
				+ ", pub_date=" + pub_date + ", children=" + children + "]";
	}
	
	
	
	
	
	
	
	
}
