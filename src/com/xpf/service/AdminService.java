package com.xpf.service;

import com.xpf.entity.Admin;

public interface AdminService {

	Admin login(String username,String password);
	
	Integer updatePassword(Admin admin,String newPassword);
}
