package com.xpf.service;

import java.util.List;

import com.xpf.entity.Banner;

public interface BannerService {

	/*
	 *	分页
	 */
	List<Banner> queryBannerByPage(Integer page,Integer rows);
	
	/*
	 *	总条数
	 */
	Integer totalBanner();
	
	/*
	 * 修改状态
	 */
	void updateStatus(Integer id,Integer status);
	
	/*
	 * 添加轮播图
	 */
	void saveBanner(Banner banner);
	
	/*
	 * 修改轮播图信息
	 */
	void modifyBanner(Banner banner);
}
