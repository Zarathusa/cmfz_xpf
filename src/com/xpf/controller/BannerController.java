package com.xpf.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xpf.entity.Banner;
import com.xpf.service.BannerService;


@RestController
@RequestMapping("banner")
public class BannerController {

	@Autowired
	private BannerService bannerService;
	private Map<String, Object> map=new HashMap<String,Object>();
	
	@RequestMapping("showBanner")
	public Map<String,Object> showBanner(Integer page,Integer rows){
		
		try {
			List<Banner> banners = bannerService.queryBannerByPage(page, rows);
			Integer total = bannerService.totalBanner();
			map.put("total", total);
			map.put("rows", banners);
			map.put("success", 200);
			map.put("message","查询轮播图成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message","查询失败！");
		}
		return map;
	}
	
	@RequestMapping("updateStatus")
	public Map<String,Object> updateStatus(Integer id,Integer status){
		
		try {
			bannerService.updateStatus(id, status);
			map.put("success", 200);
			map.put("message", "图片状态修改成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "图片状态修改失败！");
		}
		return map;
		
	}
	
	/*
	 * 添加轮播图、上传轮播图
	 */
	@RequestMapping("add")
	public Map<String,Object> addBanner(@RequestParam("pictureUpload")MultipartFile pictureUpload,Banner banner,HttpSession session){
		
		try {
			//获取文件名
			String filename = pictureUpload.getOriginalFilename();
			//获取上传文件夹路径
			String realPath = session.getServletContext().getRealPath("/picture");
			//若没有文件夹则创建文件夹
			File file = new File(realPath);
			if(!file.exists()){
				file.mkdir();
			}
			//给文件名加上时间戳，使文件名唯一，不会被覆盖
			String newName=new Date().getTime()+"-"+filename;
			//文件上传
			pictureUpload.transferTo(new File(realPath,newName));
			
			//将轮播图相关信息添加进数据库
			banner.setPicPath("/picture/"+newName);
			bannerService.saveBanner(banner);
			
			map.put("success", 200);
			map.put("message", "轮播图添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "轮播图添加失败！");
		}
		return map;
	}
	
	/*
	 * 修改轮播图信息
	 */
	@RequestMapping("modify")
	public Map<String,Object> modifyBanner(Banner banner){
		System.out.println(banner);
		try {
			bannerService.modifyBanner(banner);
			map.put("success", 200);
			map.put("message", "修改轮播图信息成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "修改轮播图信息失败！");
		}
		return map;
	}
	
}
