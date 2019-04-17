package com.xpf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xpf.entity.Album;

public interface AlbumDAO extends BaseDAO<Album>{

	/*
	 * 查询所有
	 */
	List<Album> queryAllByPage(@Param("begin")Integer begin,@Param("end")Integer end);
	
	/*
	 * 查询条数
	 */
	Integer getCount();
	
	/*
	 * 添加专辑
	 */
	
	/*
	 * 添加章节后count作+1运算 
	 */
	void addCount(Integer id);
	
	/*
	 * 专辑按时间排序 
	 */
	List<Album> queryByDate();
}
