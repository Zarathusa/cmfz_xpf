package com.xpf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xpf.dao.BannerDAO;
import com.xpf.entity.Banner;
import com.xpf.service.BannerService;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class BannerServiceImpl implements BannerService{

	@Autowired
	private BannerDAO bannerDAO;
	
	@Override
	public List<Banner> queryBannerByPage(Integer page, Integer rows) {
		Integer begin=(page-1)*rows;
		Integer end=page*rows;
		return bannerDAO.queryAllBannerByPage(begin, end);
	}

	@Override
	public Integer totalBanner() {
		return bannerDAO.countBanner();
	}

	@Override
	@Transactional
	public void updateStatus(Integer id, Integer status) {
		bannerDAO.modifyStatus(id, status);
	}

	@Override
	@Transactional
	public void saveBanner(Banner banner) {
		bannerDAO.add(banner);
	}

	@Override
	public void modifyBanner(Banner banner) {
		bannerDAO.update(banner);
	}

}
