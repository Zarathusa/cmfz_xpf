package com.xpf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xpf.entity.Guru;

public interface GuruDAO extends BaseDAO<Guru>{

	List<Guru> queryAllByPage(@Param("begin")Integer begin,@Param("end")Integer end);
	
	Integer countGuru();
	
	//修改状态
	Integer updateStatus(@Param("id")Integer id,@Param("status")Integer status);
}
