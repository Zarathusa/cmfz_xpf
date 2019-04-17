package com.xpf.entity;

import java.io.Serializable;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;

public class User implements Serializable {

	@Excel(name="ID")
	private Integer id;
	@Excel(name="手机号",width=30)
	private String phone;
	@Excel(name="密码")
	private String password;
	@Excel(name="盐值")
	private String salt;
	@Excel(name="头像",type=2,width=40,height=35)
	private String head_img;
	@Excel(name="姓名")
	private String name;
	@Excel(name="法名")
	private String legal_name;
	@Excel(name="性别")
	private String sex;
	@Excel(name="城市")
	private String city;
	@Excel(name="签名",width=30)
	private String sign;
	@Excel(name="状态")
	private Integer status;
	@Excel(name="注册时间",width=30)
	private String reg_date;
	@ExcelIgnore
	private Guru guru;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String phone, String password, String salt,
			String head_img, String name, String legal_name, String sex,
			String city, String sign, Integer status, String reg_date, Guru guru) {
		super();
		this.id = id;
		this.phone = phone;
		this.password = password;
		this.salt = salt;
		this.head_img = head_img;
		this.name = name;
		this.legal_name = legal_name;
		this.sex = sex;
		this.city = city;
		this.sign = sign;
		this.status = status;
		this.reg_date = reg_date;
		this.guru = guru;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getHead_img() {
		return head_img;
	}
	public void setHead_img(String head_img) {
		this.head_img = head_img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLegal_name() {
		return legal_name;
	}
	public void setLegal_name(String legal_name) {
		this.legal_name = legal_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public Guru getGuru() {
		return guru;
	}
	public void setGuru(Guru guru) {
		this.guru = guru;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", phone=" + phone + ", password=" + password
				+ ", salt=" + salt + ", head_img=" + head_img + ", name="
				+ name + ", legal_name=" + legal_name + ", sex=" + sex
				+ ", city=" + city + ", sign=" + sign + ", status=" + status
				+ ", reg_date=" + reg_date + ", guru=" + guru + "]";
	}
	
	
}
