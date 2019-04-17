package com.xpf.controller;

import it.sauronsoftware.jave.Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xpf.entity.Album;
import com.xpf.entity.Chapter;
import com.xpf.service.AlbumService;
import com.xpf.service.ChapterService;

@RestController
@RequestMapping("chapter")
public class ChapterController {

	@Autowired
	private ChapterService chapterService;
	@Autowired
	private AlbumService albumService;
	private Map<String,Object> map=new HashMap<String,Object>();
	
	@RequestMapping("add")
	public Map<String,Object> addChapter(@RequestParam("audioUpload")MultipartFile audioUpload,
			Chapter chapter,Integer album_id,HttpSession session
			){
		try{
			System.out.println("---------");
			//获取文件名
			String filename = audioUpload.getOriginalFilename();
			//获取上传文件夹路径
			String realPath = session.getServletContext().getRealPath("/audio");
			//若没有文件夹则创建文件夹
			File file = new File(realPath);
			if(!file.exists()){
				file.mkdir();
			}
			//给文件名加上时间戳，使文件名唯一，不会被覆盖
			String newName=new Date().getTime()+"-"+filename;
			//文件上传
			audioUpload.transferTo(new File(realPath,newName));
			
			//获取音频的大小
			long size = audioUpload.getSize();
			chapter.setSize(size/1024/1024+"MB");
			//获取音频的时长
			Encoder encoder = new Encoder();
			long duration = encoder.getInfo(new File(realPath,newName)).getDuration();
			chapter.setDuration(duration/1000/60+"分"+duration/1000%60+"秒");
			
			//将信息添加进数据库
			Album album = new Album();
			album.setId(album_id);
			chapter.setAlbum(album);
			chapter.setUrl(newName);
			chapterService.saveChapter(chapter);
			
			//专辑中章节数加1
			albumService.addCount(album_id);
			
			map.put("success", 200);
			map.put("message", "添加章节成功！");
			
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "添加章节失败！");
		}
		
		
		return map;
	}
	
	@RequestMapping("download")
	public void downloadAudio(String url,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		
			
			//根据用户名去服务器中的指定位置获取文件
			String realPath = request.getSession().getServletContext().getRealPath("/audio");
			
			//读取文件输入流
			FileInputStream fis = new FileInputStream(new File(realPath, url));
			
			//设置响应的方式   响应头   //attachment;以附件形式下载   inline 在线打开
			response.setHeader("content-disposition","attachment;fileName=" + URLEncoder.encode(url,"UTF-8"));
			//获取响应流
			ServletOutputStream os = response.getOutputStream();
			//下载文件
			IOUtils.copy(fis,os);
			
			//关闭资源
			IOUtils.closeQuietly(fis);
			IOUtils.closeQuietly(os);
		    
	}
	
	
	
	@RequestMapping("playAudio")
	public void playAudio(String url,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		
			
			//根据用户名去服务器中的指定位置获取文件
			String realPath = request.getSession().getServletContext().getRealPath("/audio");
			
			//读取文件输入流
			FileInputStream fis = new FileInputStream(new File(realPath, url));
			
			//设置响应的方式   响应头   //attachment;以附件形式下载   inline 在线打开
			response.setHeader("content-disposition","inline;fileName=" + URLEncoder.encode(url,"UTF-8"));
			//获取响应流
			ServletOutputStream os = response.getOutputStream();
			//下载文件
			IOUtils.copy(fis,os);
			
			//关闭资源
			IOUtils.closeQuietly(fis);
			IOUtils.closeQuietly(os);
		    
	}
	
}
