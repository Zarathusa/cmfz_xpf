package com.xpf.pojo;

public class City {

	private String name;//城市
	private String value;//城市注册量
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	public City(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "City [name=" + name + ", value=" + value + "]";
	}
	
}
