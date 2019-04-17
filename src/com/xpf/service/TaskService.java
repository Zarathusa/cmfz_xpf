package com.xpf.service;

import java.util.List;

import com.xpf.entity.Task;

public interface TaskService {

	List<Task> queryAll(Integer page,Integer rows);
	
	Integer getTotal();
}
