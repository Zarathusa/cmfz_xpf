package com.xpf.zgate.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xpf.dao.AlbumDAO;
import com.xpf.dao.ArticleDAO;
import com.xpf.dao.BannerDAO;
import com.xpf.dao.UserDAO;
import com.xpf.entity.User;
import com.xpf.zgate.service.FirstPageService;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class FirstPageServiceImpl implements FirstPageService{

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private BannerDAO bannerDAO;
	@Autowired
	private AlbumDAO albumDAO;
	@Autowired
	private ArticleDAO articleDAO;
	private Map<String,Object> map=new HashMap<String,Object>();
	
	@Override
	public Map<String, Object> firstPage(Integer uid, String type,
			String sub_type) {
		System.out.println("uid:"+uid);
		System.out.println("type:"+type);
		System.out.println("sub_type:"+sub_type);
		/*
		 * 通过用户id查询上师id
		 */
		Integer guruId = userDAO.getGuruId(uid);
		/*
		 * 首页
		 */
		if("all".equals(type)){
			map.clear();
			map.put("header", bannerDAO.queryOnline());
			map.put("album",albumDAO.queryByDate());
			map.put("article",articleDAO.queryAllByGuruId(null));
		/*
		 * 闻	
		 */
		}else if("wen".equals(type)){
			map.clear();
			map.put("album",albumDAO.queryByDate());
		/*
		 * 思
		 */
		}else if("si".equals(type)){
			//上师言教（只展示用户上师的文章）
			if("ssyj".equals(sub_type)){
				map.clear();
				map.put("article",articleDAO.queryAllByGuruId(guruId));
			//显密法要（展示所有的文章）
			}else if("xmfy".equals(sub_type)){
				map.clear();
				map.put("article",articleDAO.queryAllByGuruId(null));
			}else{
				map.clear();
				map.put("error", "请传入sub_type参数值");
			}
		}else{
			map.clear();
			map.put("error", "请传入type参数值");
		}
		return map;
	}

}
