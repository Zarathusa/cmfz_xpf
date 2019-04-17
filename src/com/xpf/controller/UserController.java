package com.xpf.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;

import com.xpf.entity.User;
import com.xpf.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	private Map<String,Object> map=new HashMap<String,Object>();
	
	@RequestMapping("showAll")
	public Map<String,Object> showAllUser(Integer page,Integer rows){
		map.clear();
		try {
			Integer total = userService.getTotal();
			List<User> users = userService.queryAllUser(page, rows);
			map.put("total",total);
			map.put("rows",users);
			map.put("success", 200);
			map.put("message", "查询用户信息成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "查询用户信息失败！");
		}
		return map;
	}
	
	@RequestMapping("updateStatus")
	public Map<String,Object> updateStatus(Integer id,Integer status){
		map.clear();
		try {
			userService.updateStatus(id, status);
			map.put("success", 200);
			map.put("message", "用户状态修改成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "用户状态修改失败！");
		}
		return map;
	}
	
	
	/*
	 * 下载用户表格
	 */
	@RequestMapping("downloadTable")
	public Map<String,Object> downloadTable(HttpServletRequest request){
		map.clear();
		try {
			List<User> users = userService.queryAll();
			List<User> userss=new ArrayList<User>();
			for (User user : users) {
				user.setHead_img("D:/后期项目/code/cmfz_xpf/WebRoot"+user.getHead_img());
				userss.add(user);
			}
			//参数：标题，表名，实体类类对象，导出的集合
			Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("持明法洲用户信息表","用户信息表"),User.class, userss);

			workbook.write(new FileOutputStream(new File("D:/userInformation.xls")));
			workbook.close();
			map.put("success", 200);
			map.put("message", "下载成功（目录：D:/userInformation.xls）");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "下载失败~~~");
		}
		return map;
	}
	
	/*
	 * 用户性别统计展示 
	 */
	@RequestMapping("showSexRegDateBar")
	public Map<String,Object> showSexRegDateBar(){
		map.clear();
		try {
			map.put("months", Arrays.asList("一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"));
			map.put("man",userService.queryRegDateBySex("m"));
			map.put("woman",userService.queryRegDateBySex("f"));
			map.put("success", 200);
			map.put("message", "查询成功~~~");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "查询失败~~~");
		}
		
		return map;
	}
	
	/*
	 * 根据季度统计每个地区的用户注册量
	 */
	@RequestMapping("showQuarterCityMap")
	public Map<String,Object> showQuarterCityMap(){
		map.clear();
		try {
			map.put("data", userService.queryQuarterCity());
			map.put("success", 200);
			map.put("message", "查询成功~~~");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "查询失败~~~");
		}
		return map;
	}
	
}
