package com.xpf.dao;

import org.apache.ibatis.annotations.Param;

import com.xpf.entity.Admin;

public interface AdminDAO extends BaseDAO<Admin>{

	//登录查询
	Admin queryByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
	
	//修改密码
	Integer modifyPassword(@Param("id")Integer id,@Param("password")String password,@Param("newPassword")String newPassword);
}
