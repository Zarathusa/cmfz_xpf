package com.xpf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xpf.dao.UserDAO;
import com.xpf.entity.User;
import com.xpf.pojo.Month;
import com.xpf.pojo.UserQuarterCityMap;
import com.xpf.service.UserService;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<User> queryAllUser(Integer page, Integer rows) {
		Integer begin=(page-1)*rows;
		Integer end=page*rows;
		return userDAO.queryAllByPage(begin, end);
		
	}

	@Override
	public Integer getTotal() {
		return userDAO.getUserCount();
	}

	@Override
	@Transactional
	public void updateStatus(Integer id, Integer status) {
		userDAO.modifyStatus(id, status);
	}

	@Override
	public List<User> queryAll() {
		return userDAO.queryAll();
	}

	@Override
	public Integer[] queryRegDateBySex(String sex) {
		String month = userDAO.queryRegDateBySex(sex).toString();
		String[] strings = month.split(",");
		Integer[] arr = new Integer[strings.length];
		for (int i = 0; i < strings.length; i++) {
			arr[i]=Integer.valueOf(strings[i]);
		}
		return arr;
	}

	@Override
	public List<UserQuarterCityMap> queryQuarterCity() {
		List<UserQuarterCityMap> list = new ArrayList<UserQuarterCityMap>();
		list.add(new UserQuarterCityMap("第一季度",userDAO.queryCityRegCountByQuarter(1)));
		list.add(new UserQuarterCityMap("第二季度",userDAO.queryCityRegCountByQuarter(2)));
		list.add(new UserQuarterCityMap("第三季度",userDAO.queryCityRegCountByQuarter(3)));
		list.add(new UserQuarterCityMap("第四季度",userDAO.queryCityRegCountByQuarter(4)));
		return list;
	}

}
