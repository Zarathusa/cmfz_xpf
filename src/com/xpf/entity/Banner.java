package com.xpf.entity;

import java.io.Serializable;
import java.util.Date;

public class Banner implements Serializable{

	private Integer id;
	private String picName;
	private String picPath;
	private String description;
	private Integer status;
	private String createTime;
	private String url;
	public Banner() {
		super();
	}
	public Banner(Integer id, String picName, String picPath,
			String description, Integer status, String createTime, String url) {
		super();
		this.id = id;
		this.picName = picName;
		this.picPath = picPath;
		this.description = description;
		this.status = status;
		this.createTime = createTime;
		this.url = url;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Banner [id=" + id + ", picName=" + picName + ", picPath="
				+ picPath + ", description=" + description + ", status="
				+ status + ", createTime=" + createTime + ", url=" + url + "]";
	}
	
	
}
