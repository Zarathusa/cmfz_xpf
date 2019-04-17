package com.xpf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xpf.entity.User;
import com.xpf.pojo.City;
import com.xpf.pojo.Month;

public interface UserDAO extends BaseDAO<User>{
	
	List<User> queryAllByPage(@Param("begin")Integer begin,@Param("end")Integer end);
	
	/*
	 * 查询总条数
	 */
	Integer getUserCount();
	
	/*
	 * 更改用户状态
	 */
	void modifyStatus(@Param("id")Integer id,@Param("status")Integer status);
	
	/*
	 * 通过用户id查询上师id
	 */
	Integer getGuruId(Integer id);
	
	/*
	 *	通过性别查询用户注册的时间
	 */
	Month queryRegDateBySex(String sex);
	
	/*
	 * 通过季度查询地区的注册数量
	 */
	List<City> queryCityRegCountByQuarter(Integer quarter);
	
	/*
	 * 前端接口：用户注册
	 */
	Integer saveUser(User user);
}
