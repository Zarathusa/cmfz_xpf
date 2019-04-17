package com.xpf.zgate.controller;

import io.goeasy.GoEasy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.xpf.controller.UserController;
import com.xpf.entity.User;
import com.xpf.service.UserService;
import com.xpf.zgate.service.ZgateUserService;

@RestController
public class UserControllerForZgate {

	@Autowired
	private ZgateUserService zuserService;
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("userRegist")
	public void userRegist(User user){
		Integer addUser = zuserService.addUser(user);
		Map<String,Object> map = new HashMap<String,Object>();
		if(addUser==1){
			map.put("months", Arrays.asList("一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"));
			map.put("man",userService.queryRegDateBySex("m"));
			map.put("woman",userService.queryRegDateBySex("f"));
			map.put("data", userService.queryQuarterCity());
			JSONObject jsonObject = new JSONObject(map);
			String jsonString = jsonObject.toJSONString();
			GoEasy goEasy = 
					 new GoEasy("http://rest-hangzhou.goeasy.io", "BC-af1aee6a45d04385b509933188476b31"); 
			goEasy.publish("my_channel",jsonString); 
		}
		
	}
}
