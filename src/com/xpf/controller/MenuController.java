package com.xpf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xpf.entity.Menu;
import com.xpf.service.MenuService;

@Controller
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	private Map<String,Object> map=null;
	
	@RequestMapping("showMenu")
	@ResponseBody
	public Map<String,Object> showMenu(){
		map=new HashMap<String,Object>();
		try{
			List<Menu> allMenu = menuService.queryAllMenu();
			map.put("menu", allMenu);
			map.put("message", "加载成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("menu", 400);
			map.put("message", "加载失败！");
		}
		return map;
	} 
}
