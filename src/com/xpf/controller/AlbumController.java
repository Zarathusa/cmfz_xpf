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

import com.xpf.entity.Album;
import com.xpf.service.AlbumService;

@RestController
@RequestMapping("album")
public class AlbumController {

	@Autowired
	private AlbumService albumService;
	private Map<String,Object> map=new HashMap<String,Object>();
	
	@RequestMapping("showAll")
	public Map<String,Object> showAllAlbum(Integer page,Integer rows){
		
		try {
			List<Album> list = albumService.queryAllAlbum(page, rows);
			map.put("total", albumService.getTotal());
			map.put("rows", list);
			map.put("success", 200);
			map.put("message", "查询专辑成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "查询专辑失败！");
		}
		
		return map;
	}
	
	
	/*
	 * 添加专辑
	 */
	@RequestMapping("add")
	public Map<String,Object> addAlbum(@RequestParam("pictureUpload")MultipartFile pictureUpload,Album album,HttpSession session){
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
			
			//将信息添加进数据库
			album.setImg_path("/picture/"+newName);
			albumService.insertAlbum(album);
			map.put("success", 200);
			map.put("message", "专辑添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "专辑添加失败！");
		}
		
		return map;
	}
	
	
}
