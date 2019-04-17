package com.xpf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpf.entity.Guru;
import com.xpf.service.GuruService;

@RestController
@RequestMapping("guru")
public class GuruController {

	@Autowired
	private GuruService guruService;
	private Map<String,Object> map=new HashMap<String,Object>();
	
	@RequestMapping("showAll")
	public Map<String,Object> showAllGuru(Integer page,Integer rows){
		try {
			List<Guru> gurus = guruService.queryGuruByPage(page, rows);
			Integer total = guruService.getTotalGuru();
			map.put("total", total);
			map.put("rows", gurus);
			map.put("success", 200);
			map.put("message", "上师查询成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "上师查询失败！");
		}
		return map;
	}
	
	@RequestMapping("updateStatus")
	public Map<String,Object> updateStatus(Integer id,Integer status){
		
		try {
			Integer i = guruService.modifyStatus(id, status);
			map.put("success", 200);
			if(i==1){
				map.put("message", "状态修改成功！");
			}else{
				map.put("message", "状态修改失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "状态修改失败！");
		}
		return map;
	}
	
}
