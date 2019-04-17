package com.xpf.zgate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xpf.dao.UserDAO;
import com.xpf.entity.User;
import com.xpf.zgate.service.ZgateUserService;

@Service
@Transactional
public class ZgateUserServiceImpl implements ZgateUserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public Integer addUser(User user) {
		return userDAO.saveUser(user);
	}

}
