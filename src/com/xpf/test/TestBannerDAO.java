package com.xpf.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xpf.dao.BannerDAO;
import com.xpf.entity.Banner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestBannerDAO {

	@Autowired
	private BannerDAO bannerDAO;
	
	@Test
	public void testQueryByPage(){
		List<Banner> list = bannerDAO.queryAllBannerByPage(0, 4);
		for (Banner banner : list) {
			System.out.println(banner);
		}
		
	}
	
	@Test
	public void testCount(){
		Integer countBanner = bannerDAO.countBanner();
		System.out.println(countBanner);
	}
	
	@Test
	public void testModifyStatus(){
		bannerDAO.modifyStatus(1, 0);
	}
	
	@Test
	public void testAdd(){
		Banner banner = new Banner(null,"qq","qq","qq",null,null,null);
		bannerDAO.add(banner);
	}
}
