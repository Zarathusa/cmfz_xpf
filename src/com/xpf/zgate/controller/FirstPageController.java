package com.xpf.zgate.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpf.zgate.service.FirstPageService;

@RestController
public class FirstPageController {

	@Autowired
	private FirstPageService firstPageService;
	private Map<String,Object> map=new HashMap<String,Object>(); 
	
	@RequestMapping("first_page")
	public Map<String,Object> first_page(Integer uid,String type,String sub_type){
		try {
			map= firstPageService.firstPage(uid, type, sub_type);
			map.put("success", 200);
			map.put("message", "查询成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "查询失败！");
		}
		
		return map;
	}
}
