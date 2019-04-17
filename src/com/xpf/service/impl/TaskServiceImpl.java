package com.xpf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xpf.dao.TaskDAO;
import com.xpf.entity.Task;
import com.xpf.service.TaskService;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskDAO taskDAO;
	
	@Override
	public List<Task> queryAll(Integer page, Integer rows) {
		Integer begin=(page-1)*rows;
		Integer end=page*rows;
		return taskDAO.queryAllTaskByPage(begin, end);
	}

	@Override
	public Integer getTotal() {
		return taskDAO.getTaskCount();
	}

}
