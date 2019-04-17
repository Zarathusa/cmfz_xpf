package com.xpf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xpf.dao.AdminDAO;
import com.xpf.entity.Admin;
import com.xpf.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Admin login(String username, String password) {
		Admin admin = adminDAO.queryByUsernameAndPassword(username, password);
		return admin;
	}

	@Override
	public Integer updatePassword(Admin admin, String newPassword) {
		return adminDAO.modifyPassword(admin.getId(),admin.getPassword(), newPassword);
	}

}
