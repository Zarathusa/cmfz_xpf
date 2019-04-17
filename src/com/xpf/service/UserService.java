package com.xpf.service;

import java.util.List;

import com.xpf.entity.User;
import com.xpf.pojo.UserQuarterCityMap;

public interface UserService {

	List<User> queryAllUser(Integer page,Integer rows);
	
	Integer getTotal();
	
	void updateStatus(Integer id,Integer status);
	
	List<User> queryAll();
	
	/*
	 * 通过性别查询注册日期的分布
	 */
	Integer[] queryRegDateBySex(String sex);
	
	/*
	 * 通过季度查询地区的注册数量
	 */
	List<UserQuarterCityMap> queryQuarterCity();
}
