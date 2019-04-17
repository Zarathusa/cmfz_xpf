package com.xpf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xpf.entity.Banner;

public interface BannerDAO extends BaseDAO<Banner>{

	/*
	 * 分页展示
	 */
	List<Banner> queryAllBannerByPage(@Param("begin")Integer begin,@Param("end")Integer end);
	
	/*
	 * 计算总条数
	 */
	Integer countBanner();
	
	/*
	 * 修改状态
	 */
	void modifyStatus(@Param("id")Integer id,@Param("status")Integer status);
	
	/*
	 * 添加轮播图
	 */
	
	/*
	 * 轮播图的修改
	 */
	
	/*
	 * 查出在线的轮播图
	 */
	List<Banner> queryOnline();
}
