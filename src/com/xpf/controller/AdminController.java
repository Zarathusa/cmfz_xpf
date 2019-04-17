package com.xpf.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xpf.entity.Admin;
import com.xpf.service.AdminService;


@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	private Map<String,Object> map=new HashMap<String,Object>();

	@RequestMapping("login")
	@ResponseBody
	public Map<String,Object> queryAdmin(String username,String password,HttpSession session,String enCode){
		
		try{
			Admin admin = adminService.login(username, password);
			String validationCode=(String)session.getAttribute("validationCode");
			if(admin!=null&&validationCode.equals(enCode)){
				session.setAttribute("admin",admin);
				map.put("success", 200);
				map.put("message", "登录成功！");
			}else{
				map.put("success", 400);
				if(!validationCode.equals(enCode)){
					map.put("message", "验证码输入有误!");
				}else{
					map.put("message", "账号密码输入有误!");
				}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "登录失败！");
		}
		return map;
	}
	
	/*
	 * 退出
	 */
	@RequestMapping("exit")
	public String exit(HttpSession session){
		session.invalidate();
		return "redirect:/login.jsp";
	}
	 
	@RequestMapping("modifyPassword")
	@ResponseBody
	public Map<String,Object> modifyPassword(Admin admin,String npassword){
		try {
			Integer i = adminService.updatePassword(admin, npassword);
			map.put("success", 200);
			if(i==1){
				map.put("message", "修改密码成功！");
			}else{
				map.put("message", "你输入的原始密码不正确！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "修改密码失败！");
		}
		return map;
	}
}
