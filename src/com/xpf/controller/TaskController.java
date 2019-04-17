package com.xpf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpf.entity.Task;
import com.xpf.service.TaskService;

@RestController
@RequestMapping("task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	private Map<String,Object> map=new HashMap<String,Object>();
	
	@RequestMapping("showAll")
	public Map<String,Object> showAllTask(Integer page,Integer rows){
		try {
			List<Task> list = taskService.queryAll(page, rows);
			Integer total = taskService.getTotal();
			map.put("total", total);
			map.put("rows", list);
			map.put("success", 200);
			map.put("message", "查询功课成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "查询功课失败！");
		}
		return map;
	}
}
